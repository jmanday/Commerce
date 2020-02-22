package com.sdos.login.domain

interface LoginRepository {

    fun login(param1: String, param2: String): Boolean
}