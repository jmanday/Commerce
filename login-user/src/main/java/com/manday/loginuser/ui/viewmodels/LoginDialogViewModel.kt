package com.manday.loginuser.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.login.domain.LoginEmployeeInteractor

internal class LoginDialogViewModel(var loginEmployeeInteractor: LoginEmployeeInteractor) : ViewModel() {

    //private var employee = MediatorLiveData<Employee>()

    fun loginUser(param1: String, param2: String) {
        loginEmployeeInteractor.invoke(param1, param2)
    }
    /*
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
