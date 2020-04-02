package com.manday.loginuser.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.manday.loginuser.domain.interactors.LoginEmployeeInteractor

internal class LoginDialogViewModel(var loginEmployeeInteractor: LoginEmployeeInteractor): ExecutorViewModel() {

    private var employee = MediatorLiveData<EmployeeEntity>()
    private var employeeLivedata = MutableLiveData<EmployeeEntity>()

    fun loginUser(param1: String, param2: String): MediatorLiveData<EmployeeEntity> {
        login(param1, param2)
        return employee
    }

    private fun login(param1: String, param2: String) {
        doFirstInBackgroundWithResult({
            loginEmployeeInteractor.invoke(param1, param2)
        }, {
            it?.let {
                employeeLivedata.value = it
                employee.addSource(employeeLivedata, Observer {
                    employee.removeSource(employeeLivedata)
                    employee.value = it
                })
            }
        })
    }
}
