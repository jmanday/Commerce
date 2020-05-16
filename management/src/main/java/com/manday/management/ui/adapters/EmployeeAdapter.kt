package com.manday.employee.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coredata.utils.ordinal
import com.manday.coreui.adapter.BaseAdapter
import com.manday.management.R
import com.manday.management.ui.adapters.EmployeeItemAdapter
import com.manday.management.ui.viewholders.EmployeeManagementViewHolder

internal class EmployeeAdapter(
    var listEmployee: List<EmployeeItemAdapter>,
    listener: (EmployeeItemAdapter, View) -> Unit
) : BaseAdapter<EmployeeItemAdapter, EmployeeManagementViewHolder>(listEmployee, listener) {

    override fun generateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeManagementViewHolder {
        return when (viewType) {
            EmployeeItemAdapter.HeaderItemAdapter.ordinal() -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_item_new_task, parent, false)
                EmployeeManagementViewHolder.NewTaskViewHolder(itemView)
            }
            EmployeeItemAdapter.EmployeeModelItemAdapter.ordinal() -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_item_employee, parent, false)
                EmployeeManagementViewHolder.EmployeeViewHolder(itemView)
            }
            else -> {
                throw IllegalStateException()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listEmployee.get(position).ordinal()
    }
}
