package com.sdos.commerce.domain.interactors

import com.manday.coredata.entities.EmployeeEntity


class AddEmployeeInteractor(private val repository: EmployeeRepository): (EmployeeEntity) -> Unit {

    override fun invoke(employee: EmployeeEntity) {
        repository.addEmployee(employee)
    }
}