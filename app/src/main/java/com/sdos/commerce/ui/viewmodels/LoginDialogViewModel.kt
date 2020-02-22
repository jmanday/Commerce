package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee

class LoginDialogViewModel : ViewModel() {

    var employeeList = MutableLiveData<List<Employee>>()
    private val loginEmployeeInteractor = (CommerceApp.getInstance() as DomainInjector).provideLoginInteractor()
    private val getEmployeesInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetEmployeesInteractor()

    init {
        getEmployeesInteractor.invoke()?.let {
            employeeList.value = it.value
        }
    }

    fun loginUser(param1: String, param2: String) {
        
    }
}
