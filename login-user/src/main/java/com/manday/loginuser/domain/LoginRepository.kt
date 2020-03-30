package com.manday.loginuser.domain

interface LoginRepository {

    fun login(user: String, pass: String)
}