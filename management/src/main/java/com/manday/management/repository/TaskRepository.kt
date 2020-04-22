package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity

interface TaskRepository {

    fun getAllTasks(): LiveData<List<TaskEntity>>?

    fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>>?

    fun addTask(taskEntity: TaskEntity)
}