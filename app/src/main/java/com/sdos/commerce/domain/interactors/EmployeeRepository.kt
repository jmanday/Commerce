package com.sdos.commerce.domain.interactors

import com.manday.coredata.entities.EmployeeEntity

interface EmployeeRepository {

    fun getEmployees(): List<EmployeeEntity>?
}