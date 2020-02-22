package com.sdos.login.domain

import androidx.lifecycle.LiveData

interface EmployeeRepository {

    fun login(param1: String, param2: String): Boolean
}