package com.sdos.commerce.di


import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.FruitNetDataSource
import com.manday.coredata.datasource.SkillDataSource
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.sdos.commerce.data.datasource.net.NetController
import com.sdos.commerce.domain.*
import com.sdos.commerce.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<SkillDataSource> { RoomController() }
    single<TaskDatabaseDataSource> { RoomController() }
    single<FruitNetDataSource> { NetController() }

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