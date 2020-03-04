package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee

class EmployeeFragmentViewModel : ViewModel() {

    private var employeeList = MediatorLiveData<List<Employee>>()
    private val getEmployeesInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetEmployeesInteractor()

    fun initialize() {
        getEmployeesInteractor.invoke()?.let {source ->
            employeeList.addSource(source, Observer {
                employeeList.removeSource(source)
                employeeList.value = it
            })
        }
    }

    fun getEmployees() = employeeList
}
