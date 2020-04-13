package com.sdos.commerce.di


import com.manday.coredata.datasource.*
import com.sdos.commerce.repositories.*
import com.sdos.commerce.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<SkillDatabaseDataSource> { SkillDatabaseDataSourceImpl() }
    single<TaskDatabaseDataSource> { TaskDatabaseDataSourceImpl() }

    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { SplashViewModel() }
    viewModel { DetailTaskViewModel(get()) }
    viewModel { TaskViewModel(get()) }
}