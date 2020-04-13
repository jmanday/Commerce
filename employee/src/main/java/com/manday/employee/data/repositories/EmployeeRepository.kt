package com.manday.employee.data.repositories

import androidx.lifecycle.LiveData
import com.manday.employee.data.entities.EmployeeEntity

interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}