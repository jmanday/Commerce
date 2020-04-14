package com.sdos.commerce.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.manday.management.data.entities.TaskEntity
import com.manday.coreui.adapter.BaseAdapter
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewholders.TaskViewHolder

class TaskAdapter(var listTask: List<TaskEntity>, var listener: (TaskEntity) -> Unit): BaseAdapter<TaskEntity, TaskViewHolder>(listTask, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return TaskViewHolder(itemView)
    }
}