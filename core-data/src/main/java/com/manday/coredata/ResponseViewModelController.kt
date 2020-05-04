package com.manday.coredata

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.transformationsMapNotNull

class ResponseViewModelController<T> private constructor() {

    companion object {

        fun <T : Any> createResponseSource(source: LiveData<T?>?) =
            transformationsMapNotNull(source) { res ->
                val typeResponse = if (res != null) TypeResponse.SUCCESS else TypeResponse.NOT_FOUND
                ResponseViewModel(res, typeResponse)
            }

        fun <T> createResponse(data: T?, typeResponse: TypeResponse?): ResponseViewModel<T> {
            val typeResponseLocal = if (data == null) typeResponse else TypeResponse.NO_DATA

            return ResponseViewModel(resp = data, typeResponse = typeResponseLocal)
        }
    }
}

data class ResponseViewModel<T>(
    var resp: T? = null,
    var typeResponse: TypeResponse?
)

enum class TypeResponse {
    SUCCESS, INSERT_OK, DELETE_OK, INSERT_ERROR, DELETE_ERROR, NO_DATA, NOT_FOUND
}

