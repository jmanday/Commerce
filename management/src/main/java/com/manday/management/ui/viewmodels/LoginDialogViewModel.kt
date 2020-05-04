package com.manday.loginuser.viewmodels

import com.manday.coredata.ExecutorViewModel
import com.manday.management.repository.EmployeeRepository


internal class LoginDialogViewModel(
    private val employeeRepository: EmployeeRepository
): ExecutorViewModel() {


    fun loginUser(param1: String, param2: String) =
        doInBackground {
            employeeRepository.login(param1, param2)
        }

}
