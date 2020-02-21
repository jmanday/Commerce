package com.sdos.commerce.data

import com.sdos.login.data.LoginDataSource

class RoomController: LoginDataSource {

    override fun login(param1: String, param2: String) = Datas.user.equals(param1) && Datas.pass.equals(param2)
}