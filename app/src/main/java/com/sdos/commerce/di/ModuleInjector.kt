package com.sdos.commerce.di

import com.manday.login_user.injector.LoginUserInjector

interface ModuleInjector {

    fun provideUserLoginInjector(): LoginUserInjector
}