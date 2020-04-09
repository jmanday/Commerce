package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.repositories.EmployeeRepository
import com.sdos.commerce.util.addSourceNotNull
import com.sdos.commerce.util.removeSourceNotNull

class EmployeeViewModel(
    val employeeRepository: EmployeeRepository) : ExecutorViewModel() {

    private val employees = MediatorLiveData<List<EmployeeEntity>>()


    fun getEmployees(): LiveData<List<EmployeeEntity>> {
        employees.addSourceNotNull(employeeRepository.getEmployees(), object : Observer<List<EmployeeEntity>> {
            override fun onChanged(t: List<EmployeeEntity>?) {
                doInBackground {
                    employees.removeSourceNotNull(employeeRepository.getEmployees())
                    employees.postValue(t)
                }
            }
        })

        return employees
    }

}
