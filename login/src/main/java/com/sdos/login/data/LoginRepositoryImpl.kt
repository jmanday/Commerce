package com.sdos.login.data

import com.sdos.login.domain.LoginRepository

class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {

    override fun login(param1: String, param2: String): Boolean {
        return dataSource.login(param1, param2)
    }
}