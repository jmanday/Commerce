package com.sdos.commerce.data

interface LoginDataSource {

    fun login(param1: String, param2: String): Boolean
}