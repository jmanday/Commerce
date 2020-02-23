package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Task
import com.sdos.login.domain.TaskRepository

class GetTasksInteractor(private val taskRepository: TaskRepository): () -> LiveData<List<Task>>? {

    override fun invoke(): LiveData<List<Task>>? {
        return taskRepository.getTasks()
    }
}