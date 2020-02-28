package com.sdos.commerce.domain.interactors

import com.sdos.commerce.entities.Employee
import com.sdos.login.domain.EmployeeRepository

class AddEmployeeInteractor(private val repository: EmployeeRepository): (Employee) -> Unit {

    override fun invoke(employee: Employee) {
        repository.addEmployee(employee)
    }
}