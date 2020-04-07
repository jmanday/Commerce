package com.manday.fruit.di

import com.manday.fruit.datasource.net.FruitNetDataSource
import com.manday.fruit.datasource.net.FruitNetDataSourceImpl
import com.manday.fruit.repository.FruitRepository
import com.manday.fruit.repository.FruitRepositoryImpl
import com.manday.fruit.ui.viewmodel.FruitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fruitModuleDependencies = module {

    // Single instances
    single<FruitNetDataSource> { FruitNetDataSourceImpl() }

    single<FruitRepository> { FruitRepositoryImpl(get()) }

    // ViewModel instances
    viewModel { FruitViewModel(get()) }
}