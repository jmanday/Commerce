package com.sdos.commerce.di


import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.SkillDataSource
import com.sdos.commerce.domain.interactors.*
import com.sdos.commerce.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<SkillDataSource> { RoomController() }

    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }

    // Factory instances
    factory { GetListSkillInteractor(get()) }
    factory { AddEmployeeInteractor(get()) }

    // ViewModel instances
    viewModel { SplashFragmentViewModel() }
    viewModel { EmployeeFragmentViewModel(get()) }
    viewModel { DetailEmployeeViewModel(get(), get()) }
    viewModel { DetailTaskViewModel() }
    viewModel { SettingsViewModel() }
    viewModel { TaskFragmentViewModel() }
}