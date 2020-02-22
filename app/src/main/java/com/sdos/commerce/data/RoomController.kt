package com.sdos.commerce.data


class RoomController: LoginDataSource {

    override fun login(param1: String, param2: String) = Datas.user.equals(param1) && Datas.pass.equals(param2)
}