package com.sdos.login.domain

import androidx.lifecycle.LiveData

interface LoginRepository {

    fun login(param1: String, param2: String): LiveData<Boolean>
}