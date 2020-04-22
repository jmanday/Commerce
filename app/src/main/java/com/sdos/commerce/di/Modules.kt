package com.sdos.commerce.di

import com.sdos.commerce.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // ViewModel instances
    viewModel { SplashViewModel() }
}