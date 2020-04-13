package com.manday.employee.data.repositories

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity
import com.manday.employee.data.datasource.database.EmployeeDatabaseDataSource

internal class EmployeeRepositoryImpl(private val dataSource: EmployeeDatabaseDataSource):
    EmployeeRepository {

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