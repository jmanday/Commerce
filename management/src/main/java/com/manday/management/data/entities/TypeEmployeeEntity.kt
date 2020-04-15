package com.manday.management.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_employees")
data class TypeEmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "name")
    var name: String
)