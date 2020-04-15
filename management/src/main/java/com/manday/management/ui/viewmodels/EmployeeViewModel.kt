package com.manday.management.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
import com.manday.coredata.utils.transformWhenItChanges
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.repository.EmployeeRepository

internal class EmployeeViewModel(
    val employeeRepository: EmployeeRepository
) : ExecutorViewModel() {

    private val listEmployees = MutableLiveData<List<EmployeeEntity>>()

    /*
    fun getEmployees() =
        transformWhenItChanges(employeeRepository.getEmployees()) {
            listEmployees.value = it
            if (it == null)
                HandlerResponseViewModel.createResponse("Se ha producido un error")
            else
                HandlerResponseViewModel.createResponse(extra = it)
        }

     */
}
