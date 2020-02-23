package com.sdos.commerce

import android.app.Application
import com.sdos.commerce.data.EmployeeRepositoryImpl
import com.sdos.commerce.data.TaskRepositoryImpl
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.datasource.TaskDataSource
import com.sdos.commerce.data.datasource.database.RoomController
import com.sdos.commerce.data.injector.DataInjector
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.domain.interactors.GetEmployeesInteractor
import com.sdos.commerce.domain.interactors.GetTasksInteractor
import com.sdos.login.domain.EmployeeRepository
import com.sdos.login.domain.LoginEmployeeInteractor
import com.sdos.login.domain.TaskRepository

class CommerceApp: Application(), DomainInjector, DataInjector {

    override fun onCreate() {
        super.onCreate()
        CommerceDatabase.getInstance(applicationContext)
    }

    // BEGIN - injections layer domain
    override fun provideLoginInteractor(): LoginEmployeeInteractor {
        return LoginEmployeeInteractor(provideEmployeeRepository())
    }

    override fun provideGetEmployeesInteractor(): GetEmployeesInteractor {
        return GetEmployeesInteractor(provideEmployeeRepository())
    }

    override fun provideGetTasksInteractor(): GetTasksInteractor {
        return GetTasksInteractor(provideTaskRepository())
    }
    // END - injections layer domain

    // BEGIN - injections layer data
    override fun provideEmployeeRepository(): EmployeeRepository {
        return EmployeeRepositoryImpl(provideEmployeeDataSource())
    }

    override fun provideEmployeeDataSource(): EmployeeDataSource {
        return RoomController(this)
    }

    override fun provideTaskDataSource(): TaskDataSource {
        return RoomController(this)
    }

    override fun provideTaskRepository(): TaskRepository {
        return TaskRepositoryImpl(provideTaskDataSource())
    }
    // END - injections layer data

    companion object {
        private var instance: CommerceApp? = null

        fun getInstance(): CommerceApp? {
            if (instance == null) {
                synchronized(CommerceApp::class) {
                    instance = CommerceApp()
                }
            }

            return instance
        }
    }
}