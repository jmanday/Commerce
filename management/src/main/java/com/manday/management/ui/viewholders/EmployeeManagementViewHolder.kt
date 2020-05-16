package com.manday.management.ui.viewholders

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.management.R
import com.manday.management.ui.adapters.EmployeeItemAdapter
import kotlinx.android.synthetic.main.view_item_employee.view.*

sealed class EmployeeManagementViewHolder(itemView: View) :
    BaseViewHolder<EmployeeItemAdapter>(itemView) {
    internal class EmployeeViewHolder(
        itemView: View
    ) : EmployeeManagementViewHolder(itemView) {

        override fun onBind(
            employee: EmployeeItemAdapter,
            f: (employee: EmployeeItemAdapter, view: View) -> Unit
        ) {
            when (employee) {

            }
            itemView.transitionName =
                (employee as EmployeeItemAdapter.EmployeeModelItemAdapter).name
            itemView.tvNameEmployee.text = employee.name
            itemView.tvSkill.text = employee.skill

            Glide.with(itemView)
                .load(employee.image)
                .centerCrop()
                .placeholder(R.mipmap.placeholder)
                .into(itemView.imgMain)
            Glide.with(itemView)
                .load(employee.image)
                .centerCrop()
                .placeholder(R.mipmap.placeholder)
                .into(itemView.imgProfile as ImageView)

            itemView.setOnClickListener {
                f(employee, itemView)
            }
        }
    }

    internal class NewTaskViewHolder(
        itemView: View
    ) : EmployeeManagementViewHolder(itemView) {

        override fun onBind(
            headerItem: EmployeeItemAdapter,
            f: (t: EmployeeItemAdapter, v: View) -> Unit
        ) {

            itemView.setOnClickListener {
                f(headerItem, itemView)
            }
        }
    }
}
