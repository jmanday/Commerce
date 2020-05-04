package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.domain.EmployeeModel

internal interface EmployeeRepository {

    fun login(user: String, pass: String): LiveData<EmployeeModel?>?

    fun getEmployees(): LiveData<List<EmployeeModel>?>?

    fun addEmployee(employeeModel: EmployeeModel)

}