package com.manday.loginuser.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.controllers.RoomController
import com.manday.management.data.dao.EmployeeDao
import com.manday.management.data.entities.EmployeeEntity


internal class LoginDatabaseDataSourceImpl: LoginDatabaseDataSource {

    private var employeeDao: EmployeeDao? = null

    init {
        employeeDao = RoomController.getInstance()?.employeeDao()
    }

    override fun login(param1: String, param2: String): LiveData<EmployeeEntity>? {
        return employeeDao?.getEmployee(param1, param2)
    }
}