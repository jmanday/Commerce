package com.manday.loginuser.repository

import com.manday.coredata.utils.transformMapNotNull
import com.manday.loginuser.datasource.LoginDatabaseDataSource
import com.manday.management.data.entities.toEmployee

internal class LoginRepositoryImpl(var dataSource: LoginDatabaseDataSource): LoginRepository {

    override fun login(user: String, pass: String) =
        transformMapNotNull(dataSource.login(user, pass)) {
            it.toEmployee()
        }

}