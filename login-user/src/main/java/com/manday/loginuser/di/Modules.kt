package com.manday.loginuser.di

import com.manday.coredata.controllers.RoomController
import com.manday.coredata.datasource.EmployeeDatabaseDataSource
import com.manday.loginuser.repository.LoginRepository
import com.manday.loginuser.repository.LoginRepositoryImpl
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginUserModuleDependencies = module {

    // Single instances
    single<EmployeeDatabaseDataSource> { RoomController() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }


    // ViewModel instances
    viewModel { LoginDialogViewModel(get()) }
}