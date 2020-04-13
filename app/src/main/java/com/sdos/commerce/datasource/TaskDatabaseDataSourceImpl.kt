package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.TaskEntity
import com.manday.coredata.entities.TypeTaskEntity
import com.sdos.commerce.dao.TaskDao
import com.sdos.commerce.dao.TypeTaskDao
import com.sdos.commerce.data.room.RoomController

class TaskDatabaseDataSourceImpl: TaskDatabaseDataSource {

    private var taskDao: TaskDao? = null
    private var typeTaskDao: TypeTaskDao? = null

    init {
        taskDao = RoomController.getTaskDao()
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