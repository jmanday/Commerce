package com.sdos.commerce.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

open class Executor: CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected suspend fun doInBackground(funcion: () -> Unit) {
        withContext(Dispatchers.IO) {
            funcion.invoke()
        }
    }

    protected fun cancelExecutor() {
        job.cancel()
    }
}