package com.manday.management.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.manday.coredata.utils.transformMapResponse
import com.manday.coredata.utils.transformationsNotNull
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.data.entities.toEmployee
import com.manday.management.domain.EmployeeModel

internal class EmployeeRepositoryImpl(private val dataSource: EmployeeDatabaseDataSource):
    EmployeeRepository {

    override fun login(user: String, pass: String) =
        transformMapResponse(dataSource.login(user, pass)) {
            it?.toEmployee()
        }

    override fun getEmployees() =
        transformationsNotNull(dataSource.getEmployees()) {
            it?.map { it.toEmployee() }
        }


    override fun addEmployee(employeeEntity: EmployeeEntity) {
        dataSource.addEmployee(employeeEntity)
    }

    override fun updateEmployee(employeeEntity: EmployeeEntity?) {
        dataSource.updateEmployee(employeeEntity)
    }
}