package com.manday.loginuser.data

interface LoginDataSource {

    fun login(user: String, pass: String)
}