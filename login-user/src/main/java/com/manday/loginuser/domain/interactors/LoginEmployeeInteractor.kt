package com.sdos.login.domain

import com.manday.loginuser.domain.LoginRepository

internal class LoginEmployeeInteractor(var repository: LoginRepository): (String, String) -> Unit {

    override fun invoke(user: String, pass: String) {
        return repository.login(user, pass)
    }
}
