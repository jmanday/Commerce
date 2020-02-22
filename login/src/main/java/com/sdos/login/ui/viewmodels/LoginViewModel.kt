package com.sdos.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.sdos.login.domain.LoginInteractor

class LoginViewModel(private val loginInteractor: LoginInteractor): ViewModel() {

    fun loginUser(user: String, pass: String) {
        loginInteractor.invoke(user, pass)
    }
}