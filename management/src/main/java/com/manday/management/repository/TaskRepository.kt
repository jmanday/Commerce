package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.domain.TaskModel

internal interface TaskRepository {

    fun getTasks(): LiveData<List<TaskModel>?>?

    fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>?>?

    fun addTask(taskEntity: TaskEntity)
}