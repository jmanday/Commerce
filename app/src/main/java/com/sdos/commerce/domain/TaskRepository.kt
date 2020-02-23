package com.sdos.login.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Task

interface TaskRepository {

    fun getTasks(): LiveData<List<Task>>?
}