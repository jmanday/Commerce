package com.sdos.commerce.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import java.util.*

fun String.toBitmap(): Bitmap {
    val imageBytes = Base64.getMimeDecoder().decode(this)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}

fun<T, U> transformWhenItChanges(source: LiveData<T>?, f: (T) -> U): LiveData<U> {
    val mediatorLiveData = MediatorLiveData<U>()

    source?.let {
        it.observeForever {
            mediatorLiveData.value = f(it)
        }
    }

    return mediatorLiveData
}