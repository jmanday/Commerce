package com.sdos.commerce.data.injector

import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.login.domain.EmployeeRepository

interface DataInjector {

    fun provideEmployeeRepository(): EmployeeRepository

    fun provideEmployeeDataSource(): EmployeeDataSource
}