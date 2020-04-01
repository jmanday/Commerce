package com.sdos.commerce.di


import com.sdos.commerce.domain.interactors.EmployeeRepository
import com.sdos.commerce.domain.interactors.EmployeeRepositoryImpl
import com.sdos.commerce.domain.interactors.GetEmployeesInteractor
import com.sdos.commerce.ui.viewmodels.EmployeeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    single<EmployeeRepository> {
        EmployeeRepositoryImpl(get())
    }

    factory {
        GetEmployeesInteractor(get())
    }

    viewModel {
        EmployeeFragmentViewModel(get())
    }
}