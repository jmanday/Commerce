package com.manday.management.data.datasource

import androidx.lifecycle.LiveData

internal interface EmployeeDatabaseDataSource {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employee: EmployeeEntity)

    fun updateEmployee(employee: EmployeeEntity?)
}