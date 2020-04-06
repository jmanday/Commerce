package com.manday.loginuser.repository

import com.manday.coredata.entities.EmployeeEntity
import com.manday.loginuser.datasource.LoginDatabaseDataSource

internal class LoginRepositoryImpl(var dataSource: LoginDatabaseDataSource): LoginRepository {

    override fun login(user: String, pass: String): EmployeeEntity? {
        return dataSource.login(user, pass)
    }
}