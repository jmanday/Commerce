package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.domain.Employee

internal interface EmployeeRepository {

    fun login(user: String, pass: String): LiveData<Employee?>?

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}