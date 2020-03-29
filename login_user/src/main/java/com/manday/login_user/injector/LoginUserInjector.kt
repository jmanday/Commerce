package com.manday.login_user.injector

import com.manday.login_user.BaseLoginDialogView

interface LoginUserInjector {

    fun provideLoginDialogView(): BaseLoginDialogView
}