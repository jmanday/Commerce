package com.sdos.commerce.data.datasource

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Task
import com.sdos.commerce.entities.TypeTask

interface TaskDataSource {

    fun getTasks(): LiveData<List<Task>>?

    fun getTypeTasks(): LiveData<List<TypeTask>>?
}