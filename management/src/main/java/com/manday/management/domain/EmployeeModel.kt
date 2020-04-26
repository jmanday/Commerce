package com.manday.management.domain

import com.manday.management.data.entities.EmployeeEntity
import java.io.Serializable

data class EmployeeModel (
    var id: Int? = null,
    var name: String = "",
    var surname: String = "",
    var email: String = "",
    var typeEmployee: Int = 1,
    var skillEmployee: Int = 0,
    var skillEmployeeDescription: String = "",
    var phone: String = "",
    var country: String = "",
    var image: String = ""
): Serializable

fun EmployeeModel.toEmployeeEntity() =
    EmployeeEntity().also {
        it.id = this.id
        it.name = this.name
        it.surname = this.surname
        it.email = this.email
        it.image = this.image
        it.skill = this.skillEmployee.plus(1)
    }

