package com.sdos.commerce.domain.interactors

import com.manday.coredata.entities.EmployeeEntity

class GetEmployeesInteractor(private val repository: EmployeeRepository): () -> List<EmployeeEntity>? {

    override fun invoke(): List<EmployeeEntity>? {
        return repository.getEmployees()
    }
}