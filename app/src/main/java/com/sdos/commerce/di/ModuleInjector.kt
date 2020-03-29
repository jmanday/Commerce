package com.sdos.commerce.di

import com.manday.loginuser.injector.LoginUserInjector

interface ModuleInjector {

    fun provideUserLoginInjector(): LoginUserInjector
}