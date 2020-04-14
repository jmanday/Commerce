package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity

internal interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}