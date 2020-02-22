package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee

class LoginDialogViewModel : ViewModel() {

    var employeeList = MutableLiveData<List<Employee>>()
    private val loginUserInteractor = (CommerceApp.getInstance() as DomainInjector).provideLoginInteractor()

    init {

    }

    fun loginUser(param1: String, param2: String) {
        loginUserInteractor.invoke(param1, param2)?.let {
            employeeList.value = it.value
        }
    }
}
