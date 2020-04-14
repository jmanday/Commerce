package com.manday.loginuser.repository

import androidx.lifecycle.LiveData
import com.manday.management.domain.Employee

internal interface LoginRepository {

    fun login(user: String, pass: String): LiveData<Employee>
}