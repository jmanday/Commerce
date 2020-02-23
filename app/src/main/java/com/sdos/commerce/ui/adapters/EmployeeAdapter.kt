package com.sdos.commerce.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdos.commerce.entities.Employee

class EmployeeAdapter(private val listEmployee: List<Employee>, private val listener: (Employee) -> Unit): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return listEmployee.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.onBind(listEmployee.get(position))
    }

    inner class EmployeeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(employee: Employee) {

        }
    }
}