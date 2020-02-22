package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.login.domain.LoginRepository

class LoginRepositoryImpl: LoginRepository {

    private lateinit var dataSource: LoginDataSource

    override fun login(param1: String, param2: String): LiveData<Boolean> {
        return dataSource.login(param1, param2)
    }
}