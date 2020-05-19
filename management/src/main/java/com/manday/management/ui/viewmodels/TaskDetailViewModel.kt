package com.manday.management.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.TaskRepository
import org.koin.java.KoinJavaComponent.inject

internal class TaskDetailViewModel : ExecutorViewModel() {

    private val taskRepository: TaskRepository by inject((TaskRepository::class.java))
    var listEmployees = MediatorLiveData<EmployeeModel>()
    var typeTasks = MediatorLiveData<TypeTaskEntity>()


    init {

    }


    //fun getListEmployees() = employeeRepository.getEmployees()

    fun typeTasks() = taskRepository.getAllTypeTasks()

}