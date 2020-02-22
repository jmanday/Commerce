package com.sdos.commerce.data

import android.content.Context
import android.util.Log
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.room.CommerceDatabase


class RoomController(context: Context):
    EmployeeDataSource {

    private var db: CommerceDatabase? = null
    private var employeeDao: EmployeeDao? = null

    init {
        db = CommerceDatabase.getInstance(context)
        employeeDao = db?.employeeDao()
    }


    override fun login(param1: String, param2: String): Boolean {
        val a = employeeDao?.getAllEmployees()?.value

        if (a.isNullOrEmpty()) {
            Log.d("COMMERCE", "Null")
        }
        else {
            Log.d("COMMERCE", "NOOO Null")
        }

        return true
    }
}