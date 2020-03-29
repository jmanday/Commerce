package com.manday.loginuser.viewmodels

import androidx.lifecycle.ViewModel


internal class LoginDialogViewModel : ViewModel() {

    //private var employee = MediatorLiveData<Employee>()

    //private val loginEmployeeInteractor = (CommerceApp.getInstance() as DomainInjector).provideLoginInteractor()

    /*
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

     */
}
