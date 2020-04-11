package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.manday.coredata.entities.TaskEntity
import com.manday.coredata.entities.TypeTaskEntity
import com.sdos.commerce.repositories.EmployeeRepository
import com.sdos.commerce.repositories.TaskRepository
import com.sdos.commerce.listeners.ViewModelListener

class DetailTaskViewModel(
    private val employeeRepository: EmployeeRepository,
    private val taskRepository: TaskRepository
): ExecutorViewModel() {

    private lateinit var baseView: ViewModelListener
    private lateinit var listEmployees: List<EmployeeEntity>
    private lateinit var typeTasks: List<TypeTaskEntity>
    private val listEmployeeObserver = Observer<List<EmployeeEntity>> {
        listEmployees = it
    }
    private val typeTasksObserver = Observer<List<TypeTaskEntity>> {
        typeTasks = it
    }

    init {
        //employeeRepository.getEmployees()?.observeForever(listEmployeeObserver)
        taskRepository.getAllTypeTasks()?.observeForever(typeTasksObserver)
    }

    override fun onCleared() {
        super.onCleared()
        //employeeRepository.getEmployees()?.removeObserver(listEmployeeObserver)
        taskRepository.getAllTypeTasks()?.removeObserver(typeTasksObserver)
    }

    fun setListener(baseView: ViewModelListener) {
        this.baseView = baseView
    }

    fun getListEmployees() = employeeRepository.getEmployees()

    fun getTypeTasks() = taskRepository.getAllTypeTasks()

    fun getEmployeeBySkill(skills: List<Int>) = listEmployees.filter { skills.contains(it.skill) }

    fun getSkillFromTask(idTypeTask: Int) = typeTasks.get(idTypeTask).skillNeeded

    fun getTypeTask(position: Int) = typeTasks.get(position)

    fun addTask(task: TaskEntity) {
        doInParallel (
            {
                taskRepository.addTask(task)
            },
            {
                employeeRepository.updateEmployee(listEmployees.find { it.id == task.idEmployee })
            },
            {
                baseView.showMessage("La tarea ha sido añadida correctamente", true)
            })
    }
}