package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addSourceNotNull
import com.manday.coredata.utils.removeSourceNotNull
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.EmployeeRepository

internal class EmployeeViewModel(
    val employeeRepository: EmployeeRepository
) : ExecutorViewModel() {

    private val employees = MediatorLiveData<List<EmployeeModel>?>()

    fun employees(): LiveData<List<EmployeeModel>?> {
        employees.addSourceNotNull(employeeRepository.getEmployees(), Observer<List<EmployeeModel>?> { t ->
            employees.removeSourceNotNull(employeeRepository.getEmployees())
            employees.postValue(t)
        })

        return employees
    }

}
