package com.manday.loginuser.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.loginuser.repository.LoginRepository
import com.manday.management.domain.Employee

internal class LoginDialogViewModel(
    private val loginRepository: LoginRepository): ExecutorViewModel() {

    private var employeeLivedata = MutableLiveData<Employee>()

    fun loginUser(param1: String, param2: String): LiveData<Employee> {
        login(param1, param2)
        return employeeLivedata
    }

    private fun login(param1: String, param2: String) {
        loginRepository.login(param1, param2).observeForever {
            val a = it
            val b = 22
        }
        /*
        doFirstInBackgroundWithResult({
            loginRepository.login(param1, param2)
        }, {
            it?.let {
                employeeLivedata.value = it
            }
        })

         */
    }
}
