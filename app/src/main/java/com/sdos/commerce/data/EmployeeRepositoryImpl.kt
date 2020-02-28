package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.entities.Employee
import com.sdos.login.domain.EmployeeRepository

class EmployeeRepositoryImpl(private val dataSource: EmployeeDataSource): EmployeeRepository {

    override fun login(param1: String, param2: String): LiveData<Employee>? {
        return dataSource.login(param1, param2)
    }

    override fun getEmployees(): LiveData<List<Employee>>? {
        return dataSource.getEmployees()
    }

    override fun addEmployee(employee: Employee) {
        dataSource.addEmployee(employee)
    }
}