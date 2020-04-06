package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.TaskEntity
import com.manday.coredata.entities.TypeTaskEntity

interface TaskRepository {

    fun getAllTasks(): LiveData<List<TaskEntity>>?

    fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>>?

    fun addTask(taskEntity: TaskEntity)
}