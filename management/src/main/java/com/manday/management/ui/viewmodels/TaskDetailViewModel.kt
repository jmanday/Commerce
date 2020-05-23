package com.manday.management.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addSourceNotNull
import com.manday.coredata.utils.removeSourceNotNull
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.domain.EmployeeModel
import com.manday.management.domain.TaskModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.TaskRepository
import org.koin.java.KoinJavaComponent.inject

internal class TaskDetailViewModel : ExecutorViewModel() {

    private val employeeRepository: EmployeeRepository by inject(EmployeeRepository::class.java)
    private val taskRepository: TaskRepository by inject((TaskRepository::class.java))
    val listEmployees = MediatorLiveData<List<EmployeeModel>?>()
    val typeTasks = MediatorLiveData<List<TypeTaskEntity>?>()

    init {
        val source = doInBackground {
            taskRepository.getAllTypeTasks()
        }
        typeTasks.addSourceNotNull(source, Observer {
            typeTasks.removeSourceNotNull(source)
            typeTasks.postValue(it)
        })

    }

    fun setTypeTask(taskType: Int) {
        val source = doInBackground {
            employeeRepository.getEmployeeBySkill(taskType)
        }
        listEmployees.addSourceNotNull(source, Observer {
            listEmployees.removeSourceNotNull(source)
            listEmployees.postValue(it)
        })
    }

    fun updateTask(taskModel: TaskModel) =
        doInBackground {
            taskRepository.addTask(taskModel)
        }
}