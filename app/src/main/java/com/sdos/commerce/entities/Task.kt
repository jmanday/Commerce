package com.sdos.commerce.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "duration")
    var duration: Double,

    @ColumnInfo(name = "type")
    var type: Int,

    @ColumnInfo(name = "idEmployee")
    var idEmployee: Int?,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "state")
    var state: Int = 0
)