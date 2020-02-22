package com.sdos.commerce.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(

    var name: String,
    var description: String,
    var duration: Int,
    var type: TypeTask,
    var idEmployee: Int
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}