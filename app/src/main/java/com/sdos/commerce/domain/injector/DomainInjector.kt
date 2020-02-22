package com.sdos.commerce.domain.injector

import com.sdos.login.domain.LoginInteractor

interface DomainInjector {

    fun provideLoginInteractor(): LoginInteractor
}