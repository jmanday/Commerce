package com.manday.loginuser.domain

import com.manday.coredata.datasource.EmployeeDataSource

internal class LoginRepositoryImpl(var dataSource: EmployeeDataSource): LoginRepository {

    override fun login(user: String, pass: String) {
        dataSource.login(user, pass)
    }
}