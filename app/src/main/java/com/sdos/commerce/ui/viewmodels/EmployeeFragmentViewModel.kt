package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.domain.interactors.EmployeeRepository

class EmployeeFragmentViewModel(val employeeRepository: EmployeeRepository) : ExecutorViewModel() {

    fun getEmployees(): LiveData<List<EmployeeEntity>>? {
        return employeeRepository.getEmployees()
    }
}
