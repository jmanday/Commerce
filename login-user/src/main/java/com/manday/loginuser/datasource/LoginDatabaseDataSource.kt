package com.manday.loginuser.datasource

internal interface LoginDatabaseDataSource {

    fun login(param1: String, param2: String): EmployeeEntity?
}