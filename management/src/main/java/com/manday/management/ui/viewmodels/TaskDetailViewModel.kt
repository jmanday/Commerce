package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
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
    private lateinit var _typeTasks: MediatorLiveData<List<TypeTaskEntity>?>
    private lateinit var _listEmployees: MediatorLiveData<List<EmployeeModel>?>
    private lateinit var source: MediatorLiveData<List<EmployeeModel>?>

    val listEmployees: LiveData<List<EmployeeModel>?>
        get() {
            if (!::_listEmployees.isInitialized) {
                _listEmployees = MediatorLiveData()
                _listEmployees.addSourceNotNull(source, Observer {
                    _listEmployees.postValue(it)
                })
            }

            return _listEmployees
        }

    val typeTasks: LiveData<List<TypeTaskEntity>?>
        get() {
            if (!::_typeTasks.isInitialized) {
                _typeTasks = MediatorLiveData()
                _typeTasks.addSource(
                    doInBackground {
                        taskRepository.getAllTypeTasks()
                    }
                ) {
                    _typeTasks.postValue(it)
                }
            }

            return  _typeTasks
        }

    fun setTypeTask(taskType: Int?) {
        taskType?.let {
            if (!::source.isInitialized) {
                source = MediatorLiveData()
            }
            source.addSource(doInBackground {
                employeeRepository.getEmployeeBySkill(it)
            }) {
                source.postValue(it)
            }
        }
    }

    fun updateTask(taskModel: TaskModel) =
        doInBackground {
            taskRepository.addTask(taskModel)
        }
}