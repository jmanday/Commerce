package com.manday.management.ui.viewmodels


import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addMultipleSourceNotNull
import com.manday.management.domain.TaskModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.TaskRepository

internal class TaskViewModel(
    employeeRepository: EmployeeRepository,
    taskRespository: TaskRepository
) : ExecutorViewModel() {

    val tasks = MutableLiveData<List<TaskModel>>()

    init {
        addMultipleSourceNotNull(
            employeeRepository.getEmployees(),
            taskRespository.getTasks()
        ) { listEmployees, listTasks ->
            listTasks?.map {
                if (it.employeeId != null) {
                    it.imgEmployee = listEmployees?.find { employeeModel ->
                        employeeModel.id == it.employeeId
                    }?.image.toString()
                }
            }

            tasks.postValue(listTasks)
        }
    }

}
