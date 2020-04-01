package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.CommerceApp

class EmployeeFragmentViewModel : ViewModel() {

    private var employeeList = MediatorLiveData<List<EmployeeEntity>>()
    //private val getEmployeesInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetEmployeesInteractor()

    fun initialize() {
        /*
        getEmployeesInteractor.invoke()?.let {source ->
            employeeList.addSource(source, Observer {
                employeeList.removeSource(source)
                employeeList.value = it
            })
        }

         */
    }

    fun getEmployees() = employeeList
}
