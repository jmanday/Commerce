package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.controllers.RoomController
import com.manday.management.data.dao.TaskDao
import com.manday.management.data.dao.TypeTaskDao
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity


class TaskDatabaseDataSourceImpl: TaskDatabaseDataSource {

    private var taskDao: TaskDao? = null
    private var typeTaskDao: TypeTaskDao? = null

    init {
        taskDao = RoomController.getInstance()?.taskDao()
    }

    override fun addTask(task: TaskEntity) {
        taskDao?.addTask(task)
    }

    override fun getTasks(): LiveData<List<TaskEntity>>? {
        return taskDao?.getAllTasks()
    }

    override fun getTypeTasks(): LiveData<List<TypeTaskEntity>>? {
        return typeTaskDao?.getAllTypeTasks()
    }
}