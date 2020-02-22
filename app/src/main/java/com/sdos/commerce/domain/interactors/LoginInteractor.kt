package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee

class LoginInteractor(private val repository: EmployeeRepository): (String, String) -> LiveData<List<Employee>>? {

    override fun invoke(user: String, pass: String): LiveData<List<Employee>>? {
        return repository.login(user, pass)
    }

}