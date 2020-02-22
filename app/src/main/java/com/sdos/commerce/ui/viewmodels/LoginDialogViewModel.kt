package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee

class LoginDialogViewModel : ViewModel() {

    var employeeList = MediatorLiveData<List<Employee>>()
    private val loginEmployeeInteractor = (CommerceApp.getInstance() as DomainInjector).provideLoginInteractor()
    private val getEmployeesInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetEmployeesInteractor()

    init {
        getEmployeesInteractor.invoke()?.let {source ->
            employeeList.addSource(source, Observer {
                employeeList.removeSource(source)
                employeeList.value = it
            })
        }

    }

    fun loginUser(param1: String, param2: String) {
        loginEmployeeInteractor.invoke(param1.toInt(), param2)
    }
}
