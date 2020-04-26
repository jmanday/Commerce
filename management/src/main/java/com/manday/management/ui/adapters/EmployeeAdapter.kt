package com.manday.employee.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coreui.adapter.BaseAdapter
import com.manday.employee.ui.viewholders.EmployeeViewHolder
import com.manday.management.R
import com.manday.management.domain.EmployeeModel

internal class EmployeeAdapter(listEmployee: List<EmployeeModel>, listener: (EmployeeModel, View) -> Unit): BaseAdapter<EmployeeModel, EmployeeViewHolder>(listEmployee, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_item_employee, parent, false)
        return EmployeeViewHolder(itemView)
    }
}
