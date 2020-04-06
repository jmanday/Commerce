package com.sdos.commerce.di


import com.manday.coredata.controllers.NetController
import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.*
import com.sdos.commerce.repositories.*
import com.sdos.commerce.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<SkillDatabaseDataSource> { RoomController() }
    single<TaskDatabaseDataSource> { RoomController() }
    single<FruitNetDataSource> { NetController() }
    single<EmployeeDatabaseDataSource> { EmployeeDatabaseDataSourceImpl() }

    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
    single<FruitRepository> { FruitRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { SplashFragmentViewModel() }
    viewModel { EmployeeFragmentViewModel(get()) }
    viewModel { DetailEmployeeViewModel(get(), get()) }
    viewModel { DetailTaskViewModel(get(), get()) }
    viewModel { SettingsViewModel(get()) }
    viewModel { TaskFragmentViewModel(get()) }
}