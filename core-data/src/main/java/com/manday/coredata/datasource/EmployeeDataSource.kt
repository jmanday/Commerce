package com.manday.coredata.datasource

import com.manday.coredata.entities.EmployeeEntity

interface EmployeeDataSource {

    fun login(param1: String, param2: String): EmployeeEntity?

    fun getEmployees(): List<EmployeeEntity>?

    fun addEmployee(employee: EmployeeEntity)
}