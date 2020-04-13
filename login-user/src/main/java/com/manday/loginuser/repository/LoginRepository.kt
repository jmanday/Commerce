package com.manday.loginuser.repository

internal interface LoginRepository {

    fun login(user: String, pass: String): EmployeeEntity?
}