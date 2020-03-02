package com.sdos.commerce.util

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class ExecutorViewModel: ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected fun doFirstInBackground(background: suspend () -> Unit, foreground: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
            foreground.invoke()
        }
    }

    protected fun doInBackgroundAndWait(background: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                background.invoke()
            }
        }
    }

    protected fun waitlAndRunInForeground(foreground: suspend () -> Unit) {
        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                Thread.sleep(DELAY)
            }
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