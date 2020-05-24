package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.TypeResponse
import com.manday.management.domain.EmployeeModel

internal interface EmployeeRepository {

    fun login(user: String, pass: String): LiveData<EmployeeModel?>?

    fun getEmployees(): LiveData<List<EmployeeModel>?>?

    fun addEmployee(employeeModel: EmployeeModel): LiveData<TypeResponse?>

    fun getEmployeeBySkill(skillId: Int): LiveData<List<EmployeeModel>?>?

}