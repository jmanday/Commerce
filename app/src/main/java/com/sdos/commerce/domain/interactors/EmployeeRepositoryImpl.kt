package com.sdos.commerce.domain.interactors

import com.manday.coredata.datasource.EmployeeDataSource
import com.manday.coredata.entities.EmployeeEntity

class EmployeeRepositoryImpl(private val dataSource: EmployeeDataSource): EmployeeRepository {

    override fun getEmployees(): List<EmployeeEntity>? {
        return dataSource.getEmployees()
    }

    override fun addEmployee(employeeEntity: EmployeeEntity) {
        dataSource.addEmployee(employeeEntity)
    }
}