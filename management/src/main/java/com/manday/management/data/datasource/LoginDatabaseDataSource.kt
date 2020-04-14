package com.manday.loginuser.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.EmployeeEntity

internal interface LoginDatabaseDataSource {

    fun login(param1: String, param2: String): LiveData<EmployeeEntity>?
}