package com.sdos.commerce.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sdos.commerce.R
import com.sdos.commerce.entities.Task
import kotlinx.android.synthetic.main.list_item_view.view.*

class TaskViewHolder(itemView: View): BaseViewHolder<Task>(itemView) {

    override fun onBind(task: Task, f: (task: Task) -> Unit) {
        itemView.name.text = task.name
        itemView.state.text = String.format(task.duration.toString(), " horas")
        itemView.text_type.visibility = View.VISIBLE
        itemView.text_type.text = "Duración"
        itemView.setOnClickListener {
            f(task)
        }
        Glide.with(itemView)
            .load(task.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(itemView.img)

        itemView.setOnClickListener {
            f(task)
        }
    }
}