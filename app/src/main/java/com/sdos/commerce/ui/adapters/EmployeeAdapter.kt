package com.sdos.commerce.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import com.sdos.commerce.R
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.ui.viewholders.EmployeeViewHolder

class EmployeeAdapter(listEmployee: List<Employee>, listener: (Employee) -> Unit): BaseAdapter<Employee, EmployeeViewHolder>(listEmployee, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return EmployeeViewHolder(itemView)
    }
}
