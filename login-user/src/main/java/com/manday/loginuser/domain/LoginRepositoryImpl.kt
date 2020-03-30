package com.manday.loginuser.domain

import com.manday.loginuser.data.LoginDataSource

class LoginRepositoryImpl(var dataSource: LoginDataSource): LoginRepository {

    override fun login(user: String, pass: String) {
        dataSource.login(user, pass)
    }
}