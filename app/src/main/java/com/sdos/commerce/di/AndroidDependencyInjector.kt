package com.sdos.commerce.di

import com.sdos.commerce.data.LoginDataSource
import com.sdos.commerce.data.LoginRepositoryImpl
import com.sdos.commerce.data.RoomController
import com.sdos.login.domain.LoginInteractor
import com.sdos.login.domain.LoginRepository

class AndroidDependencyInjector {

    fun provideLoginInteractor(): LoginInteractor {
        return LoginInteractor(provideLoginRepository())
    }

    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl(provideRoomDatasource())
    }

    fun provideRoomDatasource(): LoginDataSource {
        return RoomController()
    }
}