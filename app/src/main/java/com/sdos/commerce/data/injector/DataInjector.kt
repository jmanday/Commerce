package com.sdos.commerce.data.injector

import com.sdos.commerce.data.datasource.*
import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.domain.SkillRepository
import com.sdos.login.domain.EmployeeRepository
import com.sdos.login.domain.TaskRepository

interface DataInjector {

    fun provideEmployeeRepository(): EmployeeRepository

    fun provideDatabaseEmployeeDataSource(): EmployeeDatabaseDataSource

    fun provideTaskRepository(): TaskRepository

    fun provideDatabaseTaskDataSource(): TaskDatabaseDataSource

    fun provideSkillRepository(): SkillRepository

    fun provideDatabaseSkillDataSource(): SkillDatabaseDataSource

    fun provideFruitRepository(): FruitRepository

    fun provideDatabaseFruitDataSource(): FruitDatabaseDataSource

    fun provideNetFruitDataSource(): FruitNetDataSource
}