package com.manday.loginuser.di

import com.manday.loginuser.data.LoginDataSourceImpl
import com.manday.loginuser.domain.LoginRepository
import com.manday.loginuser.domain.LoginRepositoryImpl
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import com.sdos.login.domain.LoginEmployeeInteractor
import org.koin.dsl.module

val loginUserModule = module {

    // single instance of EmployeeRepository
    single<LoginRepository> {
        LoginDataSourceImpl()
        LoginRepositoryImpl(get())
    }

    // Simple Interactor Factory
    factory {
        LoginEmployeeInteractor(get())
        LoginDialogViewModel(get())
    }
}