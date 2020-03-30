package com.manday.loginuser.data

import com.manday.coredata.controllers.RoomController

internal class LoginDataSourceImpl(var roomController: RoomController): LoginDataSource {

    override fun login(user: String, pass: String) {
        roomController.login(user, pass)
    }
}