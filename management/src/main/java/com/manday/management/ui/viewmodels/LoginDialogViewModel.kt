package com.manday.loginuser.viewmodels

import com.manday.coredata.ExecutorViewModel
import com.manday.management.repository.EmployeeRepository
import org.koin.java.KoinJavaComponent.inject


internal class LoginDialogViewModel : ExecutorViewModel() {

    private val employeeRepository: EmployeeRepository by inject((EmployeeRepository::class.java))

    fun loginUser(param1: String, param2: String) =
        doInBackground {
            employeeRepository.login(param1, param2)
        }

}
