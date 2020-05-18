package com.manday.management.domain

sealed class EmployeeAdapterModel {

    data class EmployeeItemAdapterModel(
        var id: Int,
        var name: String,
        var skill: String,
        var image: String
    ) : EmployeeAdapterModel() {

        companion object
    }

    object HeaderItemAdapterModel : EmployeeAdapterModel() {
        var text: String? = null
    }
}