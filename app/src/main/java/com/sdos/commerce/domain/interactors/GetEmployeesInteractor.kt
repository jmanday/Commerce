package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Employee
import com.sdos.login.domain.EmployeeRepository

class GetEmployeesInteractor(private val repository: EmployeeRepository): () -> LiveData<List<Employee>>? {

    override fun invoke(): LiveData<List<Employee>>? {
        return repository.getEmployees()
    }
}