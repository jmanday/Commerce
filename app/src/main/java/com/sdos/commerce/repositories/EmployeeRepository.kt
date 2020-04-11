package com.sdos.commerce.repositories

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.ResponseViewModelEntity

interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)

    fun updateEmployee(employeeEntity: EmployeeEntity?)
}