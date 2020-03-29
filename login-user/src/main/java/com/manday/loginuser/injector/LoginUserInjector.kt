package com.manday.loginuser.injector

import com.manday.loginuser.BaseLoginDialogView

interface LoginUserInjector {

    fun provideLoginDialogView(): BaseLoginDialogView
}