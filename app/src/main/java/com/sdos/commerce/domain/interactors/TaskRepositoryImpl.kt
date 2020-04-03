package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.entities.TaskEntity

class TaskRepositoryImpl(private val databaseDataSource: TaskDatabaseDataSource): TaskRepository {

    override fun getAllTasks(): LiveData<List<TaskEntity>>? {
        return databaseDataSource.getTasks()
    }
}