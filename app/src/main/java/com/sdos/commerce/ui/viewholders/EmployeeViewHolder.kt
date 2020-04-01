package com.sdos.commerce.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.R
import kotlinx.android.synthetic.main.list_item_view.view.*

class EmployeeViewHolder(itemView: View): BaseViewHolder<EmployeeEntity>(itemView) {

    override fun onBind(employee: EmployeeEntity, f: (employee: EmployeeEntity) -> Unit) {
        itemView.name.text = employee.name
        itemView.surname.text = employee.surname
        itemView.state.text = if (employee.currenTask == -1) itemView.context.resources.getString(R.string.text_state_free)
                            else String.format(itemView.context.resources.getString(R.string.text_state_busy),employee.currenTask.toString())
        itemView.text_type.visibility = View.VISIBLE
        Glide.with(itemView)
            .load(employee.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(itemView.img)

        itemView.setOnClickListener {
            f(employee)
        }
    }
}