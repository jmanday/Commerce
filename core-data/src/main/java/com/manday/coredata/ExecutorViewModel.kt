package com.manday.coredata

import androidx.lifecycle.*
import com.manday.coredata.utils.transformNoSwitchMap
import kotlinx.coroutines.*

open class ExecutorViewModel : ViewModel() {

    private val contextBackground = viewModelScope.coroutineContext + Dispatchers.IO

    /*
     * This function runs the task in background and it returns the result via emit to the Main thread.
     *  It always returns a LiveData.
     *
     */
    protected fun <T> doInBackground(background: suspend () -> LiveData<T>?) =
        liveData<T>(context = contextBackground) {
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
        return liveData<T>(context = contextBackground) {
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


    /* This function performances a task in background and it returns a result. The running is blocked until the
     *  result is available, it wait for the result
     *
     */
    protected fun <T> doInBackgroundAndReturn(
        background: suspend () -> LiveData<T?>
    ) = runBlocking {
        val res = viewModelScope.async(Dispatchers.IO) {
            Thread.sleep(1500)
            background.invoke()
        }

        res.await()
    }

    protected fun doInBackgroundAndWait(background: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
        }
    }


    protected fun waitAndRunInForeground(foreground: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Thread.sleep(DELAY)
            }
            foreground.invoke()
        }
    }

    protected fun doInParallel(t1: () -> Unit, t2: () -> Unit, foreground: () -> Unit) {
        runBlocking {
            val job = viewModelScope.launch {
                viewModelScope.launch {
                    t1.invoke()
                }

                viewModelScope.launch {
                    t2.invoke()
                }
            }

            job.join()
            foreground.invoke()
        }
        /*
        launch(coroutineContext) {
            val res1 = viewModelScope.async(Dispatchers.IO) {
                t1.invoke()
            }
            val res2 = viewModelScope.async(Dispatchers.IO) {
                t2.invoke()
            }

            res1.await()
            res2.await()

            foreground.invoke()
        }
         */
    }


    companion object {
        private const val DELAY = 5000L
    }
}