package com.sdos.commerce.data

import com.sdos.login.domain.LoginRepository

class LoginRepositoryImpl: LoginRepository {

    private lateinit var dataSource: LoginDataSource

    override fun login(param1: String, param2: String): Boolean {
        return dataSource.login(param1, param2)
    }
}