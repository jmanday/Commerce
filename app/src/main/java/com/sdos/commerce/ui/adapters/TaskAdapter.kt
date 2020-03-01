package com.sdos.commerce.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sdos.commerce.R
import com.sdos.commerce.entities.Task
import com.sdos.commerce.ui.viewholders.TaskViewHolder

class TaskAdapter(var listTask: List<Task>, var listener: (Task) -> Unit): BaseAdapter<Task, TaskViewHolder>(listTask, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return TaskViewHolder(itemView)
    }
}