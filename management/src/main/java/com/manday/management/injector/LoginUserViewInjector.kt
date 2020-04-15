package com.manday.loginuser.injector

import com.manday.loginuser.BaseLoginDialogView

interface LoginUserViewInjector {

    fun provideLoginDialogView(): BaseLoginDialogView
}