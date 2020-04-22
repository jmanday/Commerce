package com.manday.management.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.management.data.entities.TaskEntity
import com.manday.coreui.adapter.BaseAdapter
import com.manday.management.R
import com.manday.management.ui.viewholders.TaskViewHolder

class TaskAdapter(var listTask: List<TaskEntity>, var listener: (TaskEntity, View) -> Unit): BaseAdapter<TaskEntity, TaskViewHolder>(listTask, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return TaskViewHolder(itemView)
    }
}