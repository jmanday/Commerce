package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee

class LoginEmployeeInteractor(private val repository: EmployeeRepository): (Int, String) -> LiveData<Employee>? {

    override fun invoke(user: Int, pass: String): LiveData<Employee>? {
        return repository.login(user, pass)
    }

}