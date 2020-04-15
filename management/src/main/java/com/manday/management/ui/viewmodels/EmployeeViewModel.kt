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

    fun getEmployees() =
        HandlerResponseViewModel.createResponse(employeeRepository.getEmployees())

}
