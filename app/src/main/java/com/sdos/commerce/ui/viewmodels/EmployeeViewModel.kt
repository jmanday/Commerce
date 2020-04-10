package com.sdos.commerce.ui.viewmodels


import com.manday.coredata.ExecutorViewModel
import com.sdos.commerce.ResponseViewModelEntity
import com.sdos.commerce.repositories.EmployeeRepository
import com.sdos.commerce.util.transformWhenItChanges

class EmployeeViewModel(
    val employeeRepository: EmployeeRepository) : ExecutorViewModel() {

    fun getEmployees() =
        transformWhenItChanges(employeeRepository.getEmployees()) {
            ResponseViewModelEntity.createResponse(extra = it)
        }

}
