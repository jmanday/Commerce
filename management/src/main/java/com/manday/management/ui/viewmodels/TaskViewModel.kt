package com.manday.management.ui.viewmodels


import androidx.lifecycle.LiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.management.domain.TaskModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.TaskRepository

internal class TaskViewModel(
    employeeRepository: EmployeeRepository,
    taskRespository: TaskRepository
) : ExecutorViewModel() {

    var tasks: LiveData<List<TaskModel>?>? = null

    init {
        tasks = doBothInBackgroundAndMap(
            {
                taskRespository.getTasks()
            },
            {
                employeeRepository.getEmployees()
            },
            { listTasks, listEmployees ->
                listTasks?.map {
                    if (it.employeeId != null) {
                        it.imgEmployee = listEmployees?.find { employeeModel ->
                            employeeModel.id == it.employeeId
                        }?.image.toString()
                    }
                }

                listTasks
            }
        )
    }

}
