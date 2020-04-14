package com.manday.management.di

import com.manday.loginuser.datasource.LoginDatabaseDataSource
import com.manday.loginuser.datasource.LoginDatabaseDataSourceImpl
import com.manday.loginuser.repository.LoginRepository
import com.manday.loginuser.repository.LoginRepositoryImpl
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.datasource.EmployeeDatabaseDataSourceImpl
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.EmployeeRepositoryImpl
import com.manday.management.ui.viewmodels.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val managementModuleDependencies = module {

    // Single instances
    single<LoginDatabaseDataSource> { LoginDatabaseDataSourceImpl() }
    single<EmployeeDatabaseDataSource> { EmployeeDatabaseDataSourceImpl() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }


    // ViewModel instances
    viewModel { LoginDialogViewModel(get()) }
    viewModel { EmployeeViewModel(get()) }

}