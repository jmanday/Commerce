package com.sdos.commerce.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sdos.commerce.R
import com.sdos.commerce.entities.Employee
import kotlinx.android.synthetic.main.list_item_view.view.*

class EmployeeViewHolder(itemView: View): BaseViewHolder<Employee>(itemView) {

    override fun onBind(employee: Employee) {
        itemView.name.text = employee.name
        itemView.surname.text = employee.surname
        itemView.prof.text = employee.skill.toString()
        itemView.text_type.visibility = View.VISIBLE
        if (employee.image.isNotEmpty()) {
            Glide.with(itemView)
                .load(employee.image)
                .centerCrop()
                .placeholder(R.mipmap.placeholder)
                .into(itemView.img)
        }
    }
}