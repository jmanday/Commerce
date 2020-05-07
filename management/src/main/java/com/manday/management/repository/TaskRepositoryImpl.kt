package com.manday.management.repository


import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.utils.transformationsMapNotNull
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.toTaskModel

class TaskRepositoryImpl(
    private val databaseDataSource: TaskDatabaseDataSource
) : TaskRepository {

    override fun getTasks() =
        transformationsMapNotNull(databaseDataSource.getTasks()) {
            it.map { it.toTaskModel() }
        }

    override fun getAllTypeTasks() =
        databaseDataSource.getTypeTasks()

    override fun addTask(taskEntity: TaskEntity) {
        databaseDataSource.addTask(taskEntity)
    }
}