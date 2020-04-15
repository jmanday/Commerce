package com.manday.coredata.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

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

/*
 * Function that observer the source and take three options:
 *  - if "source" is null the response will be NULL
 *  - if "source" is not null and it observers its change, if the value observered is null then return a livedata with value null
 *  - if "source" is not null and it observers its change, the value observered is not null then return a livedata with value
 */
fun<T, U> transformMapResponse(source: LiveData<T>?, f: (T) -> U): LiveData<U?>? {
    source?.let {
        val liveDataItem = MutableLiveData<U?>()
        it.observeForever { newValue ->
            newValue?.let {
                liveDataItem.value = f(newValue)
            }
            liveDataItem.value = null
        }

        return liveDataItem
    }
    return null
}