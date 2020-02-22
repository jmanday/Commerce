package com.sdos.commerce

import android.app.Application
import com.sdos.commerce.data.EmployeeRepositoryImpl
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.datasource.database.RoomController
import com.sdos.commerce.data.injector.DataInjector
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.login.domain.EmployeeRepository
import com.sdos.login.domain.LoginInteractor

class CommerceApp: Application(), DomainInjector, DataInjector {

    override fun onCreate() {
        super.onCreate()
        CommerceDatabase.getInstance(applicationContext)
    }

    override fun provideLoginInteractor(): LoginInteractor {
        return LoginInteractor(provideEmployeeRepository())
    }

    override fun provideEmployeeRepository(): EmployeeRepository {
        return EmployeeRepositoryImpl(provideEmployeeDataSource())
    }

    override fun provideEmployeeDataSource(): EmployeeDataSource {
        return RoomController(this)
    }

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