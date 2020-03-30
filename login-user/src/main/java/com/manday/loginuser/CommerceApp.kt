package com.manday.loginuser

import android.app.Application
import com.manday.loginuser.di.loginUserModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CommerceApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@CommerceApp)
            modules(loginUserModule)
        }
    }
}