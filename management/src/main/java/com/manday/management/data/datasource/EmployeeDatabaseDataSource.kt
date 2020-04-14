package com.manday.management.data.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity

internal interface EmployeeDatabaseDataSource {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employee: EmployeeEntity)

    fun updateEmployee(employee: EmployeeEntity?)
}