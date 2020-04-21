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

        fun<T> createResponseForm(message: String? = null, resp: T? = null): ResponseFormViewModel<T> {
            return if (resp != null)
                ResponseFormViewModel(message, resp, TypeError.ERROR)
            else
                ResponseFormViewModel(message, resp, TypeError.SUCCESS)
        }
    }
}

data class ReponseViewModel<T> (
    var text: String,
    var resp: T? = null,
    var typeError: TypeError
)

data class ResponseFormViewModel<T> (
    var message: String?,
    var resp: T?,
    var typeError: TypeError
)

enum class TypeError {
    SUCCESS, DATASOURCE, NOT_FOUND, ERROR
}