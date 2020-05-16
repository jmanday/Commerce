package com.manday.management.ui.viewholders

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.management.R
import com.manday.management.domain.EmployeeAdapterModel
import kotlinx.android.synthetic.main.view_item_employee.view.*

internal sealed class EmployeeViewHolder(itemView: View) :
    BaseViewHolder<EmployeeAdapterModel>(itemView) {

    internal class ItemEmployeeViewHolder(
        itemView: View
    ) : EmployeeViewHolder(itemView) {

        override fun onBind(
            employee: EmployeeAdapterModel,
            f: (employee: EmployeeAdapterModel, view: View) -> Unit
        ) {
            when (employee) {

            }
            itemView.transitionName =
                (employee as EmployeeAdapterModel.EmployeeItemAdapterModel).name
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
    ) : EmployeeViewHolder(itemView) {

        override fun onBind(
            headerItem: EmployeeAdapterModel,
            f: (t: EmployeeAdapterModel, v: View) -> Unit
        ) {

            itemView.setOnClickListener {
                f(headerItem, itemView)
            }
        }
    }
}
