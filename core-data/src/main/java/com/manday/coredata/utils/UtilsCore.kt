package com.manday.coredata.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

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

fun<T, U> transformMap(source: List<T>, f: (T) -> U): List<U> {
    val transform = mutableListOf<U>()

    source.forEach {
        transform.add(f(it))
    }

    return transform
}