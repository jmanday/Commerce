package com.manday.login_user.injector

import com.manday.login_user.BaseLoginDialogView
import com.manday.login_user.views.LoginDialogView

class LoginUserInjectorImp: LoginUserInjector {

    override fun provideLoginDialogView(): BaseLoginDialogView {
        return LoginDialogView.newInstance()
    }
}