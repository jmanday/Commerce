package com.sdos.commerce.data

import androidx.lifecycle.LiveData

interface LoginDataSource {

    fun login(param1: String, param2: String): LiveData<Boolean>
}