package com.manday.management.data.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity

internal interface EmployeeDatabaseDataSource {

    fun login(param1: String, param2: String): LiveData<EmployeeEntity?>?

    fun getEmployees(): LiveData<List<EmployeeEntity>?>?

    fun addEmployee(employee: EmployeeEntity)

}