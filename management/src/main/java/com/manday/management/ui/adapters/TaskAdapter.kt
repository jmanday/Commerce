package com.manday.management.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coreui.adapter.BaseAdapter
import com.manday.management.R
import com.manday.management.domain.TaskModel
import com.manday.management.ui.viewholders.TaskViewHolder

class TaskAdapter(var listTask: List<TaskModel>, var listener: (TaskModel, View) -> Unit) :
    BaseAdapter<TaskModel, TaskViewHolder>(listTask, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_task, parent, false)
        return TaskViewHolder(itemView)
    }
}