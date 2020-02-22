package com.sdos.commerce.domain.injector

import com.sdos.commerce.domain.interactors.GetEmployeesInteractor
import com.sdos.login.domain.LoginInteractor

interface DomainInjector {

    fun provideLoginInteractor(): LoginInteractor

    fun provideGetEmployeesInteractor(): GetEmployeesInteractor
}