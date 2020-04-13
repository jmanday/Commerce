package com.manday.employee.di

import com.manday.employee.data.datasource.database.EmployeeDatabaseDataSource
import com.manday.employee.data.datasource.database.EmployeeDatabaseDataSourceImpl
import com.manday.employee.data.repositories.EmployeeRepository
import com.manday.employee.data.repositories.EmployeeRepositoryImpl
import com.manday.employee.ui.viewmodels.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val employeeModuleDependencies = module {

    // Single instances
    single<EmployeeDatabaseDataSource> { EmployeeDatabaseDataSourceImpl() }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { EmployeeViewModel(get()) }
}