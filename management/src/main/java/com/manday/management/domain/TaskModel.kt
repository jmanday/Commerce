package com.manday.management.domain

data class TaskModel(
    var id: Int? = null,
    var title: String,
    var employeeId: Int? = null,
    var state: TaskState,
    var priority: Int,
    var imgEmployee: String,
    var date: String
) : SerializableSerializable

enum class TaskState(var id: Int) {
    OPEN(0),
    CLOSE(1);

    companion object {

        fun getState(id: Int) =
            when (id) {
                0 -> {
                    OPEN
                }
                1 -> {
                    CLOSE
                }
                else -> {
                    OPEN
                }
            }
    }
}