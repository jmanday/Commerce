package com.manday.employee.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.manday.coredata.entities.EmployeeEntity
import com.manday.coreui.adapter.BaseAdapter
import com.manday.employee.ui.viewholders.EmployeeViewHolder
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewholders.EmployeeViewHolder

class EmployeeAdapter(listEmployee: List<EmployeeEntity>, listener: (EmployeeEntity) -> Unit): BaseAdapter<EmployeeEntity, EmployeeViewHolder>(listEmployee, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return EmployeeViewHolder(itemView)
    }
}
