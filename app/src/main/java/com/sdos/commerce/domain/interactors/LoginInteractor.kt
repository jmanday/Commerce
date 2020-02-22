package com.sdos.login.domain

import com.sdos.commerce.data.LoginRepositoryImpl

class LoginInteractor(): (String, String) -> Unit {

    val respository = LoginRepositoryImpl()

    override fun invoke(user: String, pass: String) {
        respository.login(user, pass)
    }

}