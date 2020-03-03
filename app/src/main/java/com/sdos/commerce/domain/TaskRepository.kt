package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Task
import com.sdos.commerce.entities.TypeTask

interface TaskRepository {

    fun getTasks(): LiveData<List<Task>>?

    fun getTypeTasks(): LiveData<List<TypeTask>>?
}