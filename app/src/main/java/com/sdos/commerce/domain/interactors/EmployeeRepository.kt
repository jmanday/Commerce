package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.EmployeeEntity

interface EmployeeRepository {

    fun getEmployees(): LiveData<List<EmployeeEntity>>?

    fun addEmployee(employeeEntity: EmployeeEntity)
}