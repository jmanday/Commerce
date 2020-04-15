package com.sdos.commerce.repositories

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity

class TaskRepositoryImpl(private val databaseDataSource: TaskDatabaseDataSource): TaskRepository {

    override fun getAllTasks(): LiveData<List<TaskEntity>>? {
        return databaseDataSource.getTasks()
    }

    override fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>>? {
        return databaseDataSource.getTypeTasks()
    }

    override fun addTask(taskEntity: TaskEntity) {
        databaseDataSource.addTask(taskEntity)
    }
}