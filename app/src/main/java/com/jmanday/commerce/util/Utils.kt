package com.jmanday.commerce.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

fun String.toBitmap(): Bitmap {
    val imageBytes = Base64.getMimeDecoder().decode(this)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}

fun<T, U> transformWhenItChanges(source: LiveData<T>?, f: (T?) -> U): LiveData<U> {
    val liveDataTransformed = MutableLiveData<U>()

    source?.let { source ->
        source.observeForever {
            if (it == null) {
                liveDataTransformed.value = f(null)
            }
            else {
                liveDataTransformed.value = f(it)
            }
        }
    }

    return liveDataTransformed
}

class TimmerTask(val f: () -> Boolean, val g: (TimmerTask) -> Unit): TimerTask() {

    override fun run() {
        if (f.invoke())
            g.invoke(this)
    }
}