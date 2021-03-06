package com.manday.fruit.di

import com.manday.fruit.datasource.database.FruitDatabaseDataSource
import com.manday.fruit.datasource.database.FruitRoomDataSource
import com.manday.fruit.datasource.net.FruitNetDataSource
import com.manday.fruit.datasource.net.FruitRetrofitDataSource
import com.manday.fruit.repository.FruitRepository
import com.manday.fruit.repository.FruitRepositoryImpl
import org.koin.dsl.module

val fruitModuleDependencies = module {

    // Single instances
    single<FruitNetDataSource> { FruitRetrofitDataSource() }
    single<FruitDatabaseDataSource> { FruitRoomDataSource() }

    single<FruitRepository> { FruitRepositoryImpl(get(), get()) }

}