package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.utils.transformationsNotNull
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.data.entities.toTaskModel

class TaskRepositoryImpl(
    private val databaseDataSource: TaskDatabaseDataSource
) : TaskRepository {

    override fun getTasks() =
        transformationsNotNull(databaseDataSource.getTasks()) {
            it.map { it.toTaskModel() }
        }

    override fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>>? {
        return databaseDataSource.getTypeTasks()
    }

    override fun addTask(taskEntity: TaskEntity) {
        databaseDataSource.addTask(taskEntity)
    }
}