package com.sdos.commerce.data.injector

import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.datasource.TaskDataSource
import com.sdos.login.domain.EmployeeRepository
import com.sdos.login.domain.TaskRepository

interface DataInjector {

    fun provideEmployeeRepository(): EmployeeRepository

    fun provideEmployeeDataSource(): EmployeeDataSource

    fun provideTaskRepository(): TaskRepository

    fun provideTaskDataSource(): TaskDataSource
}