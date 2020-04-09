package com.manday.coredata

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class ExecutorViewModel: ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected fun<Result> doInBackground(background: suspend () -> Result) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
        }
    }

    protected fun doFirstInBackground(background: suspend () -> Unit, foreground: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
            foreground.invoke()
        }
    }

    protected fun<T> doFirstInBackgroundWithResult(background: suspend () -> T, foreground: suspend (T) -> Unit) {
        launch(coroutineContext) {
            val res = withContext(Dispatchers.IO) {
                return@withContext background.invoke()
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

    protected fun<Result> doInBackgroundAndReturn(background: suspend () -> Result): Result {
        val task = async(Dispatchers.IO) {
            background.invoke()
        }
        return runBlocking {
            task.await()
        }
    }

    protected fun<Result> doInBackgroundAndReturn2(background: suspend () -> Result, foreground: suspend (Result) -> Unit) {
        launch(coroutineContext) {
            val task = async(Dispatchers.IO) {
                background.invoke()
            }

            val res = task.await()
            foreground.invoke(res)
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
    }

    protected fun cancelExecutor() {
        job.cancel()
    }

    companion object {
        private const val DELAY = 5000L
    }
}