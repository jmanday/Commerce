package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.transformMapResponse
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.data.entities.toEmployee

internal class EmployeeRepositoryImpl(private val dataSource: EmployeeDatabaseDataSource):
    EmployeeRepository {

    override fun login(user: String, pass: String) =
        transformMapResponse(dataSource.login(user, pass)) {
            it?.toEmployee()
        }

    override fun getEmployees(): LiveData<List<EmployeeEntity>>? {
        return dataSource.getEmployees()
    }

    override fun addEmployee(employeeEntity: EmployeeEntity) {
        dataSource.addEmployee(employeeEntity)
    }

    override fun updateEmployee(employeeEntity: EmployeeEntity?) {
        dataSource.updateEmployee(employeeEntity)
    }
}