package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.TaskEntity
import com.sdos.commerce.repositories.TaskRepository
import com.sdos.commerce.util.addSourceNotNull
import com.sdos.commerce.util.removeSourceNotNull

class TaskViewModel(
    private val taskRespository: TaskRepository) : ExecutorViewModel() {

    private val tasks = MediatorLiveData<List<TaskEntity>>()

    fun getTasks(): LiveData<List<TaskEntity>> {
        tasks.addSourceNotNull(taskRespository.getAllTasks(), object : Observer<List<TaskEntity>> {
            override fun onChanged(t: List<TaskEntity>?) {
                doInBackground {
                    tasks.removeSourceNotNull(taskRespository.getAllTasks())
                    tasks.postValue(t)
                }
            }
        })

        return tasks
    }

    fun getPendingTasks() = tasks.value?.filter { it.state == 0 }

    fun getCompletedTasks() = tasks.value?.filter { it.state == 1 }

    fun getAllTasks() =  tasks.value

}
