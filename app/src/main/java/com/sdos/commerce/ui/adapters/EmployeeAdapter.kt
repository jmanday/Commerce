package com.sdos.commerce.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sdos.commerce.R
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.util.toBitmap
import kotlinx.android.synthetic.main.list_item_view.view.*

class EmployeeAdapter(private val listEmployee: List<Employee>, private val listener: (Employee) -> Unit): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listEmployee.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.onBind(listEmployee.get(position))
    }

    inner class EmployeeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(employee: Employee) {
            itemView.name.text = employee.name
            itemView.surname.text = employee.surname
            itemView.prof.text = employee.skill.toString()
            if (employee.image.isNotEmpty()) {
                Glide.with(itemView)  
                    .load(employee.image)
                    .centerCrop()
                    .placeholder(R.mipmap.placeholder)
                    .into(itemView.img)
            }
        }
    }
}