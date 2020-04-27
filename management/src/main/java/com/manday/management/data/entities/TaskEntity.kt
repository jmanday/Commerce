package com.manday.management.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manday.management.domain.TaskModel
import com.manday.management.domain.TaskState
import java.io.Serializable

@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String = String(),

    @ColumnInfo(name = "description")
    var description: String = String(),

    @ColumnInfo(name = "duration")
    var duration: Double = 0.0,

    @ColumnInfo(name = "type")
    var type: Int = 0,

    @ColumnInfo(name = "idEmployee")
    var idEmployee: Int? = 0,

    @ColumnInfo(name = "image")
    var image: String = String(),

    @ColumnInfo(name = "state")
    var state: Int = 0,

    @ColumnInfo(name = "priority")
    var priority: Int = 0,

    @ColumnInfo(name = "date")
    var date: String? = null
): Serializable

fun TaskEntity.toTaskModel() =
    TaskModel(
        id = this.id,
        title = this.name,
        employeeId = this.idEmployee,
        state = TaskState.getState(this.state),
        priority = this.priority,
        imgEmployee = this.image,
        date = this.date ?: String()
    )