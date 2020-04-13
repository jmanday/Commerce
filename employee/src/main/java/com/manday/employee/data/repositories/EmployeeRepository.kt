package com.manday.employee.data.repositories

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

internal interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}