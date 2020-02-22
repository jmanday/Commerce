package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee

class LoginEmployeeInteractor(private val repository: EmployeeRepository): (String, String) -> LiveData<Employee>? {

    override fun invoke(user: String, pass: String): LiveData<Employee>? {
        return repository.login(user, pass)
    }

}