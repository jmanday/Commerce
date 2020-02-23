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

    init {
        getTasksInteractor.invoke()?.let {source ->
            taskList.addSource(source, Observer {
                taskList.removeSource(source)
                taskList.value = it
            })
        }
    }

    fun getTasks() = taskList
}
