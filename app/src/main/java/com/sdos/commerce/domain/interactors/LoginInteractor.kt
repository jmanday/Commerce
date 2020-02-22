package com.sdos.login.domain

import com.sdos.commerce.data.LoginRepositoryImpl

class LoginInteractor(): (String, String) -> Boolean {

    val respository = LoginRepositoryImpl()

    override fun invoke(user: String, pass: String): Boolean {
        return respository.login(user, pass)
    }

}