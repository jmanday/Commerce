package com.manday.employee.data.datasource.database

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

internal interface EmployeeDatabaseDataSource {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employee: EmployeeEntity)

    fun updateEmployee(employee: EmployeeEntity?)
}