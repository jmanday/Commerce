package com.sdos.commerce.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sdos.commerce.R
import com.sdos.commerce.entities.Task
import com.sdos.commerce.util.toBitmap
import kotlinx.android.synthetic.main.list_item_view.view.*

class TaskAdapter(private val listTask: List<Task>, private val listener: (Task) -> Unit): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(listTask.get(position))
    }

    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(task: Task) {
            itemView.name.text = task.name
            itemView.prof.text = task.duration.toString()
            itemView.text_type.visibility = VISIBLE
        }
    }
}