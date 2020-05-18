package com.manday.employee.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coredata.utils.ordinal
import com.manday.coreui.adapter.BaseAdapter
import com.manday.management.R
import com.manday.management.domain.EmployeeAdapterModel
import com.manday.management.ui.viewholders.EmployeeViewHolder

internal class EmployeeAdapter(
    var listEmployee: List<EmployeeAdapterModel>,
    listener: (EmployeeAdapterModel, View) -> Unit
) : BaseAdapter<EmployeeAdapterModel, EmployeeViewHolder>(listEmployee, listener) {

    override fun generateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeViewHolder {
        return when (viewType) {
            EmployeeAdapterModel.HeaderItemAdapterModel.ordinal() -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_item_new_task, parent, false)
                EmployeeViewHolder.NewTaskViewHolder(itemView)
            }
            EmployeeAdapterModel.EmployeeItemAdapterModel.ordinal() -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_item_employee, parent, false)
                EmployeeViewHolder.ItemEmployeeViewHolder(itemView)
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
