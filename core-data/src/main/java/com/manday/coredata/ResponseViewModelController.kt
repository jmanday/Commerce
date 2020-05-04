package com.manday.coredata

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.transformationsMapNotNull

class ResponseViewModelController<T> private constructor() {

    companion object {

        fun <T : Any> createResponse(source: LiveData<T?>?) =
            transformationsMapNotNull(source) { res ->
                val typeError = if (res != null) TypeError.SUCCESS else TypeError.NOT_FOUND
                ReponseViewModel(res, typeError)
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

