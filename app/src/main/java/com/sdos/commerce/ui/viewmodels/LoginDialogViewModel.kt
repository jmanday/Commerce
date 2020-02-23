package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee

class LoginDialogViewModel : ViewModel() {

    private var employee = MediatorLiveData<Employee>()

    private val loginEmployeeInteractor = (CommerceApp.getInstance() as DomainInjector).provideLoginInteractor()

    fun loginUser(param1: String, param2: String): MediatorLiveData<Employee> {
        login(param1, param2)
        return employee
    }

    private fun login(param1: String, param2: String) {
        loginEmployeeInteractor.invoke(param1, param2)?.let { source ->
            employee.addSource(source, Observer {
                employee.removeSource(source)
                employee.value = it
            })
        }
    }
}
