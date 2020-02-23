package com.sdos.commerce.data.datasource

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Task

interface TaskDataSource {

    fun getTasks(): LiveData<List<Task>>?
}