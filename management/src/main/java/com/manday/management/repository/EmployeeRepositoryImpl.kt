package com.manday.management.repository

import com.manday.coredata.utils.transformMapResponse
import com.manday.coredata.utils.transformationsNotNull
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.data.entities.toEmployee
import com.manday.management.domain.EmployeeModel
import com.manday.management.domain.toEmployeeEntity

internal class EmployeeRepositoryImpl(private val databseDataSource: EmployeeDatabaseDataSource) :
    EmployeeRepository {

    override fun login(user: String, pass: String) =
        transformMapResponse(databseDataSource.login(user, pass)) {
            it?.toEmployee()
        }

    override fun getEmployees() =
        transformationsNotNull(databseDataSource.getEmployees()) {
            it?.map { it.toEmployee() }
        }


    override fun addEmployee(employeeModel: EmployeeModel) {
        databseDataSource.addEmployee(employeeModel.toEmployeeEntity())
    }

    override fun updateEmployee(employeeEntity: EmployeeEntity?) {
        databseDataSource.updateEmployee(employeeEntity)
    }
}