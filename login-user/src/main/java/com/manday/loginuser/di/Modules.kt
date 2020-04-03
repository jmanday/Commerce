package com.manday.loginuser.di

import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.EmployeeDataSource
import com.manday.loginuser.domain.LoginRepository
import com.manday.loginuser.domain.LoginRepositoryImpl
import com.manday.loginuser.domain.interactors.LoginEmployeeInteractor
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginUserModuleDependencies = module {

    // Single instances
    single<EmployeeDataSource> { RoomController() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }

    // Factory instances
    factory { LoginEmployeeInteractor(get()) }

    // ViewModel instances
    viewModel { LoginDialogViewModel(get()) }
}