package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee

interface EmployeeRepository {

    fun login(param1: String, param2: String): LiveData<Employee>?

    fun getEmployees(): LiveData<List<Employee>>?

    fun addEmployee(employee: Employee)
}