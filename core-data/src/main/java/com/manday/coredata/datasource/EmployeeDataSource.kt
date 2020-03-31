package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

interface EmployeeDataSource {

    fun login(param1: String, param2: String): LiveData<EmployeeEntity>?

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employee: EmployeeEntity)
}