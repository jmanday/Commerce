package com.jmanday.commerce.di

import com.jmanday.commerce.ui.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModuleDependencies = module {

    // ViewModel instances
    viewModel { SplashViewModel() }

}