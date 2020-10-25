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
        it.phone = this.phone
        it.email = this.email
        it.image = this.image
        it.skill = this.skillEmployee.plus(1)
    }

fun EmployeeModel.toEmployeeModelItemAdapter() =
    EmployeeAdapterModel.EmployeeItemAdapterModel(
        this.id ?: 0, String.format("%s %s", this.name, this.surname),
        this.skillEmployeeDescription, this.image
    )

fun EmployeeModel.update(employeeModel: EmployeeModel) = with(this) {
    this.name = employeeModel.name
    this.surname = employeeModel.surname
    this.phone = employeeModel.phone
    this.email = employeeModel.email
    this.image = employeeModel.image
    this.phone = employeeModel.phone
    this.country = employeeModel.country
    this.skillEmployee = employeeModel.skillEmployee
    this.skillEmployeeDescription = employeeModel.skillEmployeeDescription
}