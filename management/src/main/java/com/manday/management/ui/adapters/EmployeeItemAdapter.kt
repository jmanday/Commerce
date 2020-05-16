package com.manday.management.ui.adapters

sealed class EmployeeItemAdapter {

    data class EmployeeModelItemAdapter(
        var id: Int,
        var name: String,
        var skill: String,
        var image: String
    ) : EmployeeItemAdapter() {

        companion object
    }

    object HeaderItemAdapter : EmployeeItemAdapter() {
        var text: String? = null
    }
}