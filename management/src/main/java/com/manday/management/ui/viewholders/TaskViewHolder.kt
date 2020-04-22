package com.manday.management.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.manday.management.data.entities.TaskEntity
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.management.R
import kotlinx.android.synthetic.main.list_item_employee_view.view.*

class TaskViewHolder(itemView: View): BaseViewHolder<TaskEntity>(itemView) {

    override fun onBind(task: TaskEntity, f: (task: TaskEntity, v: View) -> Unit) {
        itemView.name.text = task.name
        itemView.state.text = String.format(task.duration.toString(), " horas")
        itemView.text_type.visibility = View.VISIBLE
        itemView.text_type.text = "Duración"
        itemView.setOnClickListener {
            f(task, itemView)
        }
        Glide.with(itemView)
            .load(task.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(itemView.img)

        itemView.setOnClickListener {
            f(task, itemView)
        }
    }
}