package com.sdos.commerce

import android.app.Application
import com.manday.loginuser.di.loginUserModuleDependencies
import com.manday.loginuser.injector.LoginUserViewInjector
import com.manday.loginuser.injector.LoginUserViewInjectorImp
import com.sdos.commerce.di.ModuleInjector
import com.sdos.commerce.di.appModuleDependencies
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
                loginUserModuleDependencies
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