package com.sdos.commerce.data.datasource.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.entities.Employee


class RoomController(context: Context): EmployeeDataSource {

    private var db: CommerceDatabase? = null
    private var employeeDao: EmployeeDao? = null

    init {
        db = CommerceDatabase.getInstance(context)
        employeeDao = db?.employeeDao()
    }


    override fun login(param1: Int, param2: String): LiveData<Employee>?  {
        return employeeDao?.getEmployee(param1, param2)
    }

    override fun getEmployees(): LiveData<List<Employee>>? {
        return employeeDao?.getAllEmployees()
    }
}