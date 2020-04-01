package com.manday.loginuser.domain

import com.manday.coredata.entities.EmployeeEntity

internal interface LoginRepository {

    fun login(user: String, pass: String): EmployeeEntity?
}