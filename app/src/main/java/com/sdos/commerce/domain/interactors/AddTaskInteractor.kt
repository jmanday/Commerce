package com.sdos.commerce.domain.interactors

import com.sdos.commerce.entities.Task
import com.sdos.login.domain.TaskRepository

class AddTaskInteractor(private val repository: TaskRepository): (Task) -> Unit {

    override fun invoke(p1: Task) {
        repository.addTask(p1)
    }
}