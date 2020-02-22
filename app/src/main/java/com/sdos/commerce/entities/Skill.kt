package com.sdos.commerce.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skills")
data class Skill(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "name")
    var name: String
)