package com.sdos.commerce.data.datasource


interface EmployeeDataSource {

    fun login(param1: String, param2: String): Boolean
}