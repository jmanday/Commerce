package com.sdos.commerce.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(

    var name: String,
    var surname: String,
    var email: String,
    var typeEmployee: TypeEmployee,
    var phone: String,
    var pass:  String,
    var hours: Int,
    var skill: Skill,
    var listTask: List<Task>
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}