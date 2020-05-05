package com.manday.coredata

import androidx.lifecycle.*
import com.manday.coredata.utils.transformNoSwitchMap
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class ExecutorViewModel: ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    /*
     * This function runs the task in background and it returns the result via emit to the Main thread.
     *  It always returns a LiveData.
     *
     */
    protected fun <T> doInBackground(background: suspend () -> LiveData<T>?) =
        liveData<T>(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            background.invoke()?.let {
                emitSource(it)
            }
        }

    /*
     * This function runs two tasks in background. It runs the first one and when the result is got, then
     *  it runs the second one. When it already has both results then It can run the function map for both and
     *  return the result from this function map.
     *  It always returns a LiveData.
     *
     */
    protected fun <T, U> doBothInBackgroundAndMap(
        funcion1: () -> LiveData<T>?,
        function2: suspend () -> LiveData<U>?,
        function3: (T?, U?) -> T
    ): LiveData<T> {
        return liveData<T>(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            function2.invoke()?.switchMap { skills ->
                transformNoSwitchMap(funcion1.invoke()) { employees ->
                    function3.invoke(employees, skills)
                }
            }?.let {
                emitSource(
                    it
                )
            }
        }
    }


    protected fun <T> doInBackgroundAndReturn(
        background: suspend () -> LiveData<T?>
    ) = runBlocking {
        val res = async(Dispatchers.IO + job) {
            Thread.sleep(1500)
            background.invoke()
        }

        res.await()
    }

    protected fun<T> doFirstInBackgroundWithResult(background: suspend () -> T, foreground: suspend (T) -> Unit) {
        launch(coroutineContext) {
            val res = withContext(Dispatchers.IO) {
                background.invoke()
            }
            foreground.invoke(res)
        }
    }

    protected fun doInBackgroundAndWait(background: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
        }
    }


    protected fun waitAndRunInForeground(foreground: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                Thread.sleep(DELAY)
            }
            foreground.invoke()
        }
    }

    protected fun doInParallel(t1: () -> Unit, t2: () -> Unit, foreground: () -> Unit) {
        runBlocking {
            val job = launch(coroutineContext) {
                launch(coroutineContext) {
                    t1.invoke()
                }

                launch(coroutineContext) {
                    t2.invoke()
                }
            }

            job.join()
            foreground.invoke()
        }
        /*
        launch(coroutineContext) {
            val res1 = async(Dispatchers.IO) {
                t1.invoke()
            }
            val res2 = async(Dispatchers.IO) {
                t2.invoke()
            }

            res1.await()
            res2.await()

            foreground.invoke()
        }
         */
    }

    protected fun cancelExecutor() {
        job.cancel()
    }

    companion object {
        private const val DELAY = 5000L
    }
}