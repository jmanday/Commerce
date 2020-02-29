package com.sdos.commerce.util

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class ExecutorViewModel: ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected fun doInBackground(funcion: suspend () -> Unit) {
        launch {
            withContext(Dispatchers.IO) {
                funcion.invoke()
            }
        }
    }

    protected fun cancelExecutor() {
        job.cancel()
    }
}