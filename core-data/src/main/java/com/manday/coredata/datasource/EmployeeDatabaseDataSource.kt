package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

interface EmployeeDatabaseDataSource {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employee: EmployeeEntity)

    fun updateEmployee(employee: EmployeeEntity?)
}