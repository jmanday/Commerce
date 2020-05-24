package com.manday.coredata.utils

sealed class TypeResponse(var codeResponse: Int) {

    class Success : TypeResponse(CODE_RESPONSE_SUCCESS)
    class InsertSuccessfully : TypeResponse(CODE_RESPONSE_INSERT_SUCCESS)
    class InsertError : TypeResponse(CODE_RESPONSE_DELETE_SUCCESS)
    class DeleteSuccessfully : TypeResponse(CODE_RESPONSE_INSERT_ERROR)
    class DeleteError : TypeResponse(CODE_RESPONSE_DELETE_ERROR)
    class NoData : TypeResponse(CODE_RESPONSE_NO_DATA)
    class NotFound : TypeResponse(CODE_RESPONSE_NOT_FOUND)

    companion object {
        const val CODE_RESPONSE_SUCCESS = 200
        const val CODE_RESPONSE_INSERT_SUCCESS = 201
        const val CODE_RESPONSE_DELETE_SUCCESS = 202
        const val CODE_RESPONSE_INSERT_ERROR = 301
        const val CODE_RESPONSE_DELETE_ERROR = 302
        const val CODE_RESPONSE_NO_DATA = 303
        const val CODE_RESPONSE_NOT_FOUND = 304
    }
}
