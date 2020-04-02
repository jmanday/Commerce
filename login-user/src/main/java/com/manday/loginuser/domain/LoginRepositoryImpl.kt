package com.manday.loginuser.domain

import com.manday.coredata.datasource.EmployeeDataSource
import com.manday.coredata.entities.EmployeeEntity

internal class LoginRepositoryImpl(var dataSource: EmployeeDataSource): LoginRepository {

    override fun login(user: String, pass: String): EmployeeEntity? {
        return dataSource.login(user, pass)
    }
}