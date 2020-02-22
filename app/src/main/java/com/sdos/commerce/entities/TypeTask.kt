package com.sdos.commerce.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_task")
data class TypeTask(

    var name: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}