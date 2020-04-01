package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.manday.coredata.entities.TaskEntity
import com.sdos.commerce.CommerceApp

class TaskFragmentViewModel : ViewModel() {

    private var taskList = MediatorLiveData<List<TaskEntity>>()
    //private val getTasksInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetTasksInteractor()

    fun initialize() {
        /*
        getTasksInteractor.invoke()?.let {source ->
            taskList.addSource(source, Observer {
                taskList.removeSource(source)
                taskList.value = it
            })
        }

         */
    }

    fun getAllTasks() = taskList.value

    fun getPendingTasks() = taskList.value?.filter { it.state == 0 }

    fun getCompletedTasks() = taskList.value?.filter { it.state == 1 }

    fun getTasks() = taskList
}
