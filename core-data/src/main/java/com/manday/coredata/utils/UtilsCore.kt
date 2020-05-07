package com.manday.coredata.utils

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

fun <T, U> transformationsMapNotNull(source: LiveData<T>?, f: (T) -> U?): LiveData<U?>? {
    return source?.let {
        Transformations.map(it, f)
    }
}

/*
 * The value received is returned on a LiveData as
 *   - null if the value is null
 *   - passed to a function and the value returned for that is assigned to the LiveData
 */
fun <T, U> transformInLiveData(value: T?, f: (T) -> U): LiveData<U?> {
    val response = MutableLiveData<U>()
    val localValue = if (value == null) null else f(value)

    response.postValue(localValue)

    return response
}


/*
 * Function that take two sources<T> and return a LiveData<U>
 *  - It runs the source1 and if the result != null, call to the function update and set the value in the liveData calling to function
 *  - If source1 returns a null, then source2 is launched and if the result is set on the LiveData, calling to function or not.
 *  - update() needs to be run in background
 */
fun <T, U> addMultipleDataSource(
    source1: LiveData<T?>,
    source2: LiveData<T?>?,
    update: suspend (T) -> Unit,
    function: (T?) -> U?
): LiveData<U?> {
    val result = MediatorLiveData<U>()
    val scope = CoroutineScope(Dispatchers.IO)
    var job: Job? = null

    result.addSource(source1) { res1 ->
        if (res1 != null) {
            job = scope.launch {
                update(res1)
            }
            result.value = function(res1)

        } else {
            source2?.let {
                result.addSource(source2) { res2 ->
                    result.value = function(res2)
                }
            }
        }
    }

    job?.let {
        if (it.isCompleted) {
            it.cancel()
            scope.coroutineContext
        }
    }

    return result
}

fun <T> transformNoSwitchMap(source: LiveData<T>?, f: (T) -> T): LiveData<T> {
    val res = MutableLiveData<T>()

    source?.let { source ->
        source.observeForever {
            res.postValue(f(it))
        }
    }

    return res
}
