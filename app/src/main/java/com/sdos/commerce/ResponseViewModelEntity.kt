package com.sdos.commerce

class ResponseViewModelEntity<T> private constructor(){

    var text: String = String()
    var extra: T? = null
    var extraList: List<T>? = null
    var typeResponse: TypeResponse = TypeResponse.TEXT

    companion object {

        fun<T> createResponse(text: String, extra: T? = null, extraList: List<T>? = null): ResponseViewModelEntity<T> {
            val response = ResponseViewModelEntity<T>()
            if (text.isNotEmpty()) {
                response.text = text
            }

            if (extra != null) {
                response.extra = extra
                response.typeResponse = TypeResponse.EXTRA
            }

            if (!extraList.isNullOrEmpty()) {
                response.extraList = extraList
                response.typeResponse = TypeResponse.EXTRA_LIST
            }

            return response
        }
    }
}

enum class TypeResponse {
    TEXT, EXTRA, EXTRA_LIST, TEXT_EXTRA
}