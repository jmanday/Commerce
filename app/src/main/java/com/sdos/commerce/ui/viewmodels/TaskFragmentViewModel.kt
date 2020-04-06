package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.TaskEntity
import com.sdos.commerce.repositories.TaskRepository
import com.sdos.commerce.util.ExecutorViewModel

class TaskFragmentViewModel(private val taskRespository: TaskRepository) : ExecutorViewModel() {

    var taskList: List<TaskEntity>? = null

    fun getAllTasks() = taskList

    fun getPendingTasks() = taskList?.filter { it.state == 0 }

    fun getCompletedTasks() = taskList?.filter { it.state == 1 }

    fun getTasks(): LiveData<List<TaskEntity>>? {
        return taskRespository.getAllTasks()
    }
}
