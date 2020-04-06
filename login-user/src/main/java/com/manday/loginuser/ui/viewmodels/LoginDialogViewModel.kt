package com.manday.loginuser.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.manday.loginuser.repository.LoginRepository

internal class LoginDialogViewModel(
    private val loginRepository: LoginRepository): ExecutorViewModel() {

    private var employeeLivedata = MutableLiveData<EmployeeEntity>()

    fun loginUser(param1: String, param2: String): LiveData<EmployeeEntity> {
        login(param1, param2)
        return employeeLivedata
    }

    private fun login(param1: String, param2: String) {
        doFirstInBackgroundWithResult({
            loginRepository.login(param1, param2)
        }, {
            it?.let {
                employeeLivedata.value = it
            }
        })
    }
}
