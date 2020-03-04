package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.entities.Task

class TaskFragmentViewModel : ViewModel() {

    private var taskList = MediatorLiveData<List<Task>>()
    private val getTasksInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetTasksInteractor()

    fun initialize() {
        getTasksInteractor.invoke()?.let {source ->
            taskList.addSource(source, Observer {
                taskList.removeSource(source)
                taskList.value = it
            })
        }
    }

    fun getAllTasks() = taskList.value

    fun getPendingTasks() = taskList.value?.filter { it.state == 0 }

    fun getCompletedTasks() = taskList.value?.filter { it.state == 1 }

    fun getTasks() = taskList
}
