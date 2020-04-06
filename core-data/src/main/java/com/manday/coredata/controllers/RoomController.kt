package com.manday.coredata.controllers

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.EmployeeDatabaseDataSource
import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.entities.EmployeeEntity
import com.manday.coredata.entities.SkillEntity
import com.manday.coredata.entities.TaskEntity
import com.manday.coredata.entities.TypeTaskEntity
import com.sdos.commerce.dao.*
import com.sdos.commerce.data.room.RoomController


class RoomController: SkillDatabaseDataSource, TaskDatabaseDataSource {

    private var db: RoomController? = null
    private var taskDao: TaskDao? = null
    private var skillDao: SkillDao? = null
    private var typeTaskDao: TypeTaskDao? = null
    private var fruitDao: FruitDao? = null

    init {
        db = RoomController.getInstance()
        taskDao = db?.taskDao()
        skillDao = db?.skillDao()
        typeTaskDao = db?.typeTaskDao()
        fruitDao = db?.fruitDao()
    }

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return skillDao?.getAllSkills()
    }

    override fun getTasks(): LiveData<List<TaskEntity>>? {
        return taskDao?.getAllTasks()
    }

    override fun getTypeTasks(): LiveData<List<TypeTaskEntity>>? {
        return typeTaskDao?.getAllTypeTasks()
    }

    override fun addTask(task: TaskEntity) {
        taskDao?.addTask(task)
    }
}