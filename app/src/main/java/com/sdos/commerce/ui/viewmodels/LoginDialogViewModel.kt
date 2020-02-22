package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.sdos.login.domain.LoginInteractor

class LoginDialogViewModel : ViewModel() {


    private val interactor = LoginInteractor()

    fun loginUser(param1: String, param2: String) {
        interactor.invoke(param1, param2)
    }
}
