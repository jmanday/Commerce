package com.manday.management.di

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
    single<EmployeeDatabaseDataSource> { EmployeeDatabaseDataSourceImpl() }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }


    // ViewModel instances
    viewModel { LoginDialogViewModel(get()) }
    viewModel { EmployeeViewModel(get()) }

    single<SkillDatabaseDataSource> { SkillDatabaseDataSourceImpl() }
    single<TaskDatabaseDataSource> { TaskDatabaseDataSourceImpl() }

    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { SplashViewModel() }
    viewModel { DetailTaskViewModel(get()) }
    viewModel { TaskViewModel(get()) }
}