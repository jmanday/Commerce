package com.manday.management.data.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity

internal class EmployeeRoomDataSource :
    EmployeeDatabaseDataSource, ManagementRoomDataSource() {

    override fun login(param1: String, param2: String): LiveData<EmployeeEntity?>? {
        return employeeDao?.getEmployee(param1, param2)
    }

    override fun addEmployee(employee: EmployeeEntity): Long? {
        return employeeDao?.addEmployee(employee)
    }

    override fun getEmployees(): LiveData<List<EmployeeEntity>?>? {
        return employeeDao?.getAllEmployees()
    }

    override fun getEmployeeBySkill(skill: Int): LiveData<List<EmployeeEntity>?>? {
        return employeeDao?.getEmployeeBySkill(skill)
    }
}