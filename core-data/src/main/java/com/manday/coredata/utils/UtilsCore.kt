package com.manday.coredata.utils

import androidx.lifecycle.*

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

fun<T> MediatorLiveData<T>.addSourceNotNull(source: LiveData<T>?, observer: Observer<T>) {
    source?.let {
        this.addSource(source, observer)
    }
}

fun<T> MediatorLiveData<T>.removeSourceNotNull(source: LiveData<T>?) {
    source?.let {
        this.removeSource(source)
    }
}

fun<T, U> addMultipleSourceNotNull(sourceA: LiveData<T>?, sourceB: LiveData<U>?, f:(T?, U?) -> Unit) {
    var resultA : T? = null
    var resultB : U? = null

    fun update() {
        if (resultA != null && resultB != null) {
            f(resultA, resultB)
        }
    }

    sourceA?.observeForever {
        resultA = it
        update()
    }

    sourceB?.observeForever {
        resultB = it
        update()
    }
}


fun<T, U> transformationsNotNull(source: LiveData<T>?, f: (T) -> U?): LiveData<U?>? {
    return source?.let {
        Transformations.map(it, f)
    }
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