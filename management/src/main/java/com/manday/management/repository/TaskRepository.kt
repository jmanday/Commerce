package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.TypeResponse
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.domain.TaskModel

internal interface TaskRepository {

    fun getTasks(): LiveData<List<TaskModel>?>?

    fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>?>?

    fun addTask(TaskModel: TaskModel): LiveData<TypeResponse?>
}