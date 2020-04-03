package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.TaskEntity

interface TaskRepository {

    fun getAllTasks(): LiveData<List<TaskEntity>>?
}