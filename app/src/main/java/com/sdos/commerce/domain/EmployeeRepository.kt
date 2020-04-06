package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}