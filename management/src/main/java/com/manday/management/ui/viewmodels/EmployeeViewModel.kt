package com.manday.management.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.ResponseViewModelEntity
import com.manday.coredata.utils.transformWhenItChanges
import com.manday.employee.data.repositories.EmployeeRepository

internal class EmployeeViewModel(
    val employeeRepository: EmployeeRepository
) : ExecutorViewModel() {

    private val listEmployees = MutableLiveData<List<EmployeeEntity>>()

    fun getEmployees() =
        transformWhenItChanges(employeeRepository.getEmployees()) {
            listEmployees.value = it
            if (it == null)
                ResponseViewModelEntity.createResponse("Se ha producido un error")
            else
                ResponseViewModelEntity.createResponse(extra = it)
        }
}
