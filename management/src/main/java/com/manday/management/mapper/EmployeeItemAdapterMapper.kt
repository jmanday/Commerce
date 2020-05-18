package com.manday.management.mapper

import com.manday.management.domain.EmployeeAdapterModel
import com.manday.management.domain.EmployeeModel
import com.manday.management.domain.toEmployeeModelItemAdapter

class EmployeeItemAdapterMapper {

    companion object {

        fun mapTo(employees: List<EmployeeModel>?): List<EmployeeAdapterModel> {
            val list = mutableListOf<EmployeeAdapterModel>()
            val header = EmployeeAdapterModel.HeaderItemAdapterModel

            list.add(header)
            employees?.let {
                list.addAll(it.map { it.toEmployeeModelItemAdapter() })
            }

            return list
        }
    }
}