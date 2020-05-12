package com.manday.management.di

import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.coredata.datasource.SkillRoomDataSource
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.datasource.TaskRoomDataSource
import com.manday.coredata.transitions.ContainerTransformFade
import com.manday.management.data.datasource.EmployeeDatabaseDataSource
import com.manday.management.data.datasource.EmployeeRoomDataSource
import com.manday.management.navigation.NavigateFromDetailEmployeeToTaskFragment
import com.manday.management.navigation.NavigateFromEmployeeToDetailFragment
import com.manday.management.repository.*
import org.koin.dsl.module

val managementModuleDependencies = module {

    // Single instances
    single<EmployeeDatabaseDataSource> { EmployeeRoomDataSource() }
    single<SkillDatabaseDataSource> { SkillRoomDataSource() }
    single<TaskDatabaseDataSource> { TaskRoomDataSource() }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    factory { ContainerTransformFade() }
    factory { NavigateFromEmployeeToDetailFragment() }

}