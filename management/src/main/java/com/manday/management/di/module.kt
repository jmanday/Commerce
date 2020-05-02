package com.manday.management.di

import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.coredata.datasource.SkillRoomDataSource
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.datasource.TaskRoomDataSource
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.datasource.EmployeeRoomDataSource
import com.manday.management.repository.*
import com.manday.management.ui.viewmodels.EmployeeDetailViewModel
import com.manday.management.ui.viewmodels.EmployeeViewModel
import com.manday.management.ui.viewmodels.TaskDetailViewModel
import com.manday.management.ui.viewmodels.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val managementModuleDependencies = module {

    // Single instances
    single<EmployeeDatabaseDataSource> { EmployeeRoomDataSource() }
    single<SkillDatabaseDataSource> { SkillRoomDataSource() }
    single<TaskDatabaseDataSource> { TaskRoomDataSource() }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { LoginDialogViewModel(get()) }
    viewModel { EmployeeViewModel(get(), get()) }
    viewModel { EmployeeDetailViewModel(get(), get()) }
    viewModel { TaskDetailViewModel(get()) }
    viewModel { TaskViewModel(get(), get()) }

}