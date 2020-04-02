package com.sdos.commerce.di


import com.sdos.commerce.domain.interactors.EmployeeRepository
import com.sdos.commerce.domain.interactors.EmployeeRepositoryImpl
import com.sdos.commerce.domain.interactors.GetEmployeesInteractor
import com.sdos.commerce.ui.viewmodels.DetailEmployeeViewModel
import com.sdos.commerce.ui.viewmodels.EmployeeFragmentViewModel
import com.sdos.commerce.ui.viewmodels.SplashFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }

    // Factory instances
    factory { GetEmployeesInteractor(get()) }

    // ViewModel instances
    viewModel { SplashFragmentViewModel() }
    viewModel { EmployeeFragmentViewModel(get()) }
    viewModel { DetailEmployeeViewModel() }
}