package com.jmanday.commerce

import android.app.Application
import com.jmanday.commerce.di.ModuleInjector
import com.jmanday.commerce.di.appModuleDependencies
import com.manday.fruit.di.fruitModuleDependencies
import com.manday.loginuser.injector.LoginUserViewInjector
import com.manday.loginuser.injector.LoginUserViewInjectorImp
import com.manday.management.di.managementModuleDependencies
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CommerceApp: Application(), ModuleInjector {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@CommerceApp)
            modules(
                appModuleDependencies,
                fruitModuleDependencies,
                managementModuleDependencies
            )
        }
    }

    override fun provideUserLoginInjector(): LoginUserViewInjector {
        return LoginUserViewInjectorImp()
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