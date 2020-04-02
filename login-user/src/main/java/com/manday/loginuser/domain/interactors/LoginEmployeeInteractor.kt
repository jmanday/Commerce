package com.manday.loginuser.domain.interactors

import com.manday.coredata.entities.EmployeeEntity
import com.manday.loginuser.domain.LoginRepository

internal class LoginEmployeeInteractor(var repository: LoginRepository): (String, String) -> EmployeeEntity? {

    override fun invoke(user: String, pass: String): EmployeeEntity? {
        return repository.login(user, pass)
    }
}
