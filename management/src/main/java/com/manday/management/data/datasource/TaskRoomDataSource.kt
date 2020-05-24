package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.datasource.ManagementRoomDataSource
import com.manday.management.data.entities.TaskEntity
import com.manday.management.data.entities.TypeTaskEntity


class TaskRoomDataSource : TaskDatabaseDataSource, ManagementRoomDataSource() {

    override fun addTask(task: TaskEntity): Long? {
        return taskDao?.addTask(task)
    }

    override fun getTasks(): LiveData<List<TaskEntity>>? {
        return taskDao?.getAllTasks()
    }

    override fun getTypeTasks(): LiveData<List<TypeTaskEntity>?>? {
        return typeTaskDao?.getAllTypeTasks()
    }
}