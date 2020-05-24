package com.manday.management.domain

import com.manday.management.data.entities.TaskEntity
import java.io.Serializable

data class TaskModel(
    var id: Int? = null,
    var title: String,
    var description: String,
    var employeeId: Int? = null,
    var state: TaskState,
    var priority: Int,
    var imgEmployee: String,
    var type: Int,
    var date: String
) : Serializable

enum class TaskState(var id: Int) {
    OPEN(0),
    CLOSE(1);

    companion object {

        fun getState(id: Int) =
            when (id) {
                1 -> {
                    CLOSE
                }
                else -> {
                    OPEN
                }
            }
    }
}

fun TaskModel.toTaskEntity() =
    TaskEntity().apply {
        id = this@toTaskEntity.id
        name = this@toTaskEntity.title
        description = this@toTaskEntity.description
        idEmployee = this@toTaskEntity.employeeId
        state = this@toTaskEntity.state.id
        date = this@toTaskEntity.date
        type = this@toTaskEntity.type
        image = this@toTaskEntity.imgEmployee
        priority = this@toTaskEntity.priority
    }