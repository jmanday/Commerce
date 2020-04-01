package com.manday.loginuser.di

import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.EmployeeDataSource
import com.manday.loginuser.domain.LoginRepository
import com.manday.loginuser.domain.LoginRepositoryImpl
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import com.sdos.login.domain.LoginEmployeeInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginUserModule = module {

    // single instance of EmployeeRepository
    single<EmployeeDataSource> {
        RoomController()
    }
    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }

    // Simple Interactor Factory
    factory { LoginEmployeeInteractor(get()) }

    viewModel { LoginDialogViewModel(get()) }
}