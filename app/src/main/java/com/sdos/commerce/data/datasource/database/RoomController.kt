package com.sdos.commerce.data.datasource.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.dao.TaskDao
import com.sdos.commerce.data.datasource.EmployeeDataSource
import com.sdos.commerce.data.datasource.TaskDataSource
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.entities.Task


class RoomController(context: Context): EmployeeDataSource, TaskDataSource {

    private var db: CommerceDatabase? = null
    private var employeeDao: EmployeeDao? = null
    private var taskDao: TaskDao? = null

    init {
        db = CommerceDatabase.getInstance(context)
        employeeDao = db?.employeeDao()
        taskDao = db?.taskDao()
    }


    override fun login(param1: String, param2: String): LiveData<Employee>?  {
        return employeeDao?.getEmployee(param1, param2)
    }

    override fun getEmployees(): LiveData<List<Employee>>? {
        return employeeDao?.getAllEmployees()
    }


    override fun getTasks(): LiveData<List<Task>>? {
        return taskDao?.getAllTasks()
    }
}