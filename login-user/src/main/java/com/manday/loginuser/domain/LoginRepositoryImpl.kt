package com.manday.loginuser.domain

import com.manday.coredata.datasource.EmployeeDatabaseDataSource
import com.manday.coredata.entities.EmployeeEntity

internal class LoginRepositoryImpl(var dataSource: EmployeeDatabaseDataSource): LoginRepository {

    override fun login(user: String, pass: String): EmployeeEntity? {
        return dataSource.login(user, pass)
    }
}