package com.sdos.commerce


class ResponseViewModelEntity<T> private constructor(){

    var text: String = String()
    var extra: T? = null

    companion object {

        fun<T> createResponse(text: String = String(), extra: T? = null) =
            ResponseViewModelEntity<T>().apply {
                this.text = text
                this.extra = extra
            }
    }
}
