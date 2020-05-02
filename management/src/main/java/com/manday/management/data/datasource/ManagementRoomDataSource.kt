package com.manday.management.data.datasource

import com.manday.management.data.controllers.RoomController
import com.manday.management.data.dao.EmployeeDao
import com.manday.management.data.dao.SkillDao
import com.manday.management.data.dao.TaskDao
import com.manday.management.data.dao.TypeTaskDao

abstract class ManagementRoomDataSource {

    protected var employeeDao: EmployeeDao? = null
    protected var skillDao: SkillDao? = null
    protected var taskDao: TaskDao? = null
    protected var typeTaskDao: TypeTaskDao? = null

    init {
        employeeDao = RoomController.getInstance()?.employeeDao()
        skillDao = RoomController.getInstance()?.skillDao()
        taskDao = RoomController.getInstance()?.taskDao()
        typeTaskDao = RoomController.getInstance()?.typeTaskDao()
    }
}