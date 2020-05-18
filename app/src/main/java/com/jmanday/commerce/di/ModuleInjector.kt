package com.jmanday.commerce.di

import com.manday.loginuser.injector.LoginUserViewInjector

interface ModuleInjector {

    fun provideUserLoginInjector(): LoginUserViewInjector
}