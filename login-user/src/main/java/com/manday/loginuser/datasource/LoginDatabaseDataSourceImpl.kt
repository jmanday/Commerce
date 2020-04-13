package com.manday.loginuser.datasource

internal class LoginDatabaseDataSourceImpl: LoginDatabaseDataSource {

    private var employeeDao: EmployeeDao? = null

    init {
        employeeDao = RoomController.getEmployeeDao()
    }

    override fun login(param1: String, param2: String): EmployeeEntity? {
        return employeeDao?.getEmployee(param1, param2)
    }
}