package com.manday.management.repository


import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.utils.toTypeResponse
import com.manday.coredata.utils.transformInLiveData
import com.manday.coredata.utils.transformationsMapNotNull
import com.manday.management.data.entities.toTaskModel
import com.manday.management.domain.TaskModel
import com.manday.management.domain.toTaskEntity

class TaskRepositoryImpl(
    private val databaseDataSource: TaskDatabaseDataSource
) : TaskRepository {

    override fun getTasks() =
        transformationsMapNotNull(databaseDataSource.getTasks()) {
            it.map { it.toTaskModel() }
        }

    override fun getAllTypeTasks() =
        databaseDataSource.getTypeTasks()

    override fun addTask(taskModel: TaskModel) =
        transformInLiveData(databaseDataSource.addTask(taskModel.toTaskEntity())) {
            it.toTypeResponse()
        }
}