package com.manday.loginuser.injector

import com.manday.loginuser.BaseLoginDialogView
import com.manday.loginuser.views.LoginDialogView

class LoginUserInjectorImp: LoginUserInjector {

    override fun provideLoginDialogView(): BaseLoginDialogView {
        return LoginDialogView.newInstance()
    }
}