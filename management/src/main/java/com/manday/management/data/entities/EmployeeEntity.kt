package com.manday.management.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manday.management.domain.EmployeeModel
import java.io.Serializable

@Entity(tableName = "employees")
data class EmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String = String(),

    @ColumnInfo(name = "surname")
    var surname: String = String(),

    @ColumnInfo(name = "email")
    var email: String = String(),

    @ColumnInfo(name = "typeEmployee")
    var typeEmployee: Int = 1,

    @ColumnInfo(name = "phone")
    var phone: String = String(),

    @ColumnInfo(name = "pass")
    var pass:  String = String(),

    @ColumnInfo(name = "hours")
    var hours: Double = 0.0,

    @ColumnInfo(name = "skill")
    var skill: Int = 0,

    @ColumnInfo(name = "listTask")
    var listTask: List<Int> = listOf(),

    @ColumnInfo(name = "currenTask")
    var currenTask: Int = 0,

    @ColumnInfo(name = "image")
    var image: String = String(),

    @ColumnInfo(name = "birthdate")
    var birthdate: String = String()
): Serializable

fun EmployeeEntity.toEmployee() =
    EmployeeModel(this.name, this.surname, this.email, this.typeEmployee, String(), this.image)