package com.manday.coredata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HandlerResponseViewModel<T> private constructor(){

    companion object {

        fun<T> createResponse(source: LiveData<T?>?): LiveData<ReponseViewModel<T>> {
            val handleError = MutableLiveData<ReponseViewModel<T>>()

            if (source == null)
                handleError.value = ReponseViewModel("", null, TypeError.DATASOURCE)
            else {
                source.observeForever { res ->
                    if (res == null)
                        handleError.value = ReponseViewModel("", null, TypeError.NOT_FOUND)
                    else {
                        handleError.value = ReponseViewModel("", res, TypeError.SUCCESS)
                    }
                }
            }

            return handleError
        }
    }
}

data class ReponseViewModel<T> (
    var text: String,
    var resp: T? = null,
    var typeError: TypeError
)

enum class TypeError {
    SUCCESS, DATASOURCE, NOT_FOUND
}