package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity

interface TaskDatabaseDataSource {

    fun getTasks(): LiveData<List<TaskEntity>>?

    fun getTypeTasks(): LiveData<List<TypeTaskEntity>?>?

    fun addTask(task: TaskEntity)
}