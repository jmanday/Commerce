package com.manday.loginuser.datasource

import com.manday.coredata.entities.EmployeeEntity

internal interface LoginDatabaseDataSource {

    fun login(param1: String, param2: String): EmployeeEntity?
}