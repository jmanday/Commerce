package com.sdos.commerce

class ResponseViewModelEntity<T> private constructor(){

    var text: String = String()
    var extra: List<T> = listOf()

    companion object {

        fun<T> createResponseWithData(text: String, extra: List<T>): ResponseViewModelEntity<T> {
            return ResponseViewModelEntity<T>().apply {
                this.text = text
                this.extra = extra
            }
        }

        fun<T> createResponseWithoutData(text: String): ResponseViewModelEntity<T> {
            return ResponseViewModelEntity<T>().apply {
                this.text = text
            }
        }
    }
}