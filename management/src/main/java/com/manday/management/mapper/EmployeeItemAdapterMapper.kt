package com.manday.management.mapper

import com.manday.management.domain.EmployeeModel
import com.manday.management.domain.toEmployeeModelItemAdapter
import com.manday.management.ui.adapters.EmployeeItemAdapter

class EmployeeItemAdapterMapper {

    companion object {

        fun mapTo(employees: List<EmployeeModel>?): List<EmployeeItemAdapter> {
            val list = mutableListOf<EmployeeItemAdapter>()
            val header = EmployeeItemAdapter.HeaderItemAdapter

            list.add(header)
            employees?.let {
                list.addAll(it.map { it.toEmployeeModelItemAdapter() })
            }

            return list
        }
    }
}