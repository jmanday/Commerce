package com.sdos.login.domain

class LoginInteractor(val respository: LoginRepository): (String, String) -> Unit {

    override fun invoke(user: String, pass: String) {
        respository.login(user, pass)
    }

}