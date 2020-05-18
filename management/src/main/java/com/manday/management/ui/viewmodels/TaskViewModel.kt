package com.manday.management.ui.viewmodels


import androidx.lifecycle.LiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.management.domain.TaskModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.TaskRepository
import org.koin.java.KoinJavaComponent.inject

internal class TaskViewModel : ExecutorViewModel() {

    private val employeeRepository: EmployeeRepository by inject(EmployeeRepository::class.java)
    private val taskRespository: TaskRepository by inject(TaskRepository::class.java)
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
