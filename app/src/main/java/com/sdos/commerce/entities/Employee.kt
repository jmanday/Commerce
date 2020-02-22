package com.sdos.commerce.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "surname")
    var surname: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "typeEmployee")
    var typeEmployee: Int,

    @ColumnInfo(name = "phone")
    var phone: String,

    @ColumnInfo(name = "pass")
    var pass:  String,

    @ColumnInfo(name = "hours")
    var hours: Double,

    @ColumnInfo(name = "skill")
    var skill: Int,

    @ColumnInfo(name = "listTask")
    var listTask: List<Int>,

    @ColumnInfo(name = "currenTask")
    var currenTask: Int
)