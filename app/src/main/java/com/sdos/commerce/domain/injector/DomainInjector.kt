package com.sdos.commerce.domain.injector

import com.sdos.commerce.domain.interactors.*
import com.sdos.login.domain.LoginEmployeeInteractor

interface DomainInjector {

    fun provideLoginInteractor(): LoginEmployeeInteractor

    fun provideGetEmployeesInteractor(): GetEmployeesInteractor

    fun provideGetTasksInteractor(): GetTasksInteractor

    fun provideGetListSkillInteractor(): GetListSkillInteractor

    fun provideAddEmployeeInteractor(): AddEmployeeInteractor

    fun provideGetTypeTaskInteractor(): GetTypeTaskInteractor

    fun provideAddTaskInteractor(): AddTaskInteractor

    fun provideGetAllFruitsInteractor(): GetAllFruitsInteractor

    fun provideAddFruitsInteractor(): AddFruitsInteractor
}