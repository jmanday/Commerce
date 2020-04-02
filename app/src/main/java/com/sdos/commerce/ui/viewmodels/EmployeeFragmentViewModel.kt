package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.domain.interactors.GetEmployeesInteractor

class EmployeeFragmentViewModel(val getEmployeesInteractor: GetEmployeesInteractor) : ExecutorViewModel() {

    private var employeeList = MediatorLiveData<List<EmployeeEntity>>()
    private val liveDataEmployeeList = MutableLiveData<List<EmployeeEntity>>()

    fun getEmployees(): MediatorLiveData<List<EmployeeEntity>> {
        doFirstInBackgroundWithResult({
            getEmployeesInteractor.invoke()
        }, {
            it?.let {source ->
                liveDataEmployeeList.value = it
                employeeList.addSource(liveDataEmployeeList, Observer {
                    employeeList.removeSource(liveDataEmployeeList)
                    employeeList.value = it
                })
            }
        })

        return employeeList
    }
}
