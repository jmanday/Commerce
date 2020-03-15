package com.sdos.commerce.data.datasource

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee


interface EmployeeDatabaseDataSource {

    fun login(param1: String, param2: String): LiveData<Employee>?

    fun getEmployees(): LiveData<List<Employee>>?

    fun addEmployee(employee: Employee)
}