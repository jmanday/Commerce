package com.manday.employee.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.management.R
import com.manday.management.domain.EmployeeModel
import kotlinx.android.synthetic.main.list_item_view.view.*

internal class EmployeeViewHolder(itemView: View): BaseViewHolder<EmployeeModel>(itemView) {

    override fun onBind(employee: EmployeeModel, f: (employee: EmployeeModel, view: View) -> Unit) {
        itemView.transitionName = employee.name
        itemView.tvNameEmployee.text = String.format("%s %s", employee.name, employee.surname)
        itemView.tvSkill.text = employee.typeEmployeeDescription
        Glide.with(itemView)
            .load(employee.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(itemView.imgMain)
        Glide.with(itemView)
            .load(employee.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(itemView.imgProfile)

        itemView.setOnClickListener {
            f(employee, itemView)
        }
    }
}