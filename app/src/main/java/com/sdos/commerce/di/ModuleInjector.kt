package com.sdos.commerce.di

import com.manday.loginuser.injector.LoginUserViewInjector

interface ModuleInjector {

    fun provideUserLoginInjector(): LoginUserViewInjector
}