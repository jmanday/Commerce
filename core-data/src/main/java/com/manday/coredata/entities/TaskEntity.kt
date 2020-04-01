package com.manday.coredata.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    var state: Int = 0
): Serializable