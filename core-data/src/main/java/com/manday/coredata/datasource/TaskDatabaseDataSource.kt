package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.TaskEntity

interface TaskDatabaseDataSource {

    fun getTasks(): LiveData<List<TaskEntity>>?

    fun getTypeTasks(): LiveData<List<TaskEntity>>?

    fun addTask(task: TaskEntity)
}