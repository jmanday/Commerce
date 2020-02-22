package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.LoginRepositoryImpl

class LoginInteractor(): (String, String) -> LiveData<Boolean> {

    val respository = LoginRepositoryImpl()

    override fun invoke(user: String, pass: String): LiveData<Boolean> {
        return respository.login(user, pass)
    }

}