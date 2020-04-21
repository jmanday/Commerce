package com.manday.management.data.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.controllers.RoomController
import com.manday.management.data.dao.EmployeeDao
import com.manday.management.data.entities.EmployeeEntity

internal class EmployeeDatabaseDataSourceImpl:
    EmployeeDatabaseDataSource {

    private var employeeDao: EmployeeDao? = null

    init {
        employeeDao = RoomController.getInstance()?.employeeDao()
    }

    override fun login(param1: String, param2: String): LiveData<EmployeeEntity?>? {
        return employeeDao?.getEmployee(param1, param2)
    }

    override fun addEmployee(employee: EmployeeEntity) {
        employeeDao?.addEmployee(employee)
    }

    override fun getEmployees(): LiveData<List<EmployeeEntity>?>? {
        return employeeDao?.getAllEmployees()
    }

    override fun updateEmployee(employee: EmployeeEntity?) {
        employee?.let {
            employeeDao?.addEmployee(it)
        }
    }
}