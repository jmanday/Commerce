package com.sdos.commerce.data

import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.login.domain.EmployeeRepository

class LoginRepositoryImpl: EmployeeRepository {

    private lateinit var dataSource: EmployeeDataSource

    override fun login(param1: String, param2: String): Boolean {
        return dataSource.login(param1, param2)
    }
}