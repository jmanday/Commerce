package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.TaskDataSource
import com.sdos.commerce.entities.Task
import com.sdos.commerce.entities.TypeTask
import com.sdos.login.domain.TaskRepository

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource): TaskRepository {

    override fun getTasks(): LiveData<List<Task>>? {
        return taskDataSource.getTasks()
    }

    override fun getTypeTasks(): LiveData<List<TypeTask>>? {
        return taskDataSource.getTypeTasks()
    }
}