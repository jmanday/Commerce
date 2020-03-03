package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.TypeTask
import com.sdos.login.domain.TaskRepository

class GetTypeTaskInteractor(private val repository: TaskRepository): () -> LiveData<List<TypeTask>>? {

    override fun invoke(): LiveData<List<TypeTask>>? {
       return repository.getTypeTasks()
    }
}