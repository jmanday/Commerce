package com.manday.management.ui.viewholders

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.management.R
import com.manday.management.domain.TaskModel
import com.manday.management.domain.TaskState
import kotlinx.android.synthetic.main.view_item_task.view.*


internal class TaskViewHolder(itemView: View) : BaseViewHolder<TaskModel>(itemView) {

    override fun onBind(task: TaskModel, f: (task: TaskModel, v: View) -> Unit) {
        itemView.transitionName = task.title
        itemView.tvTitle.text = task.title
        itemView.tvDate.text =
            String.format(itemView.context.getString(R.string.text_date), task.date)
        itemView.tvPriority.text = String.format(
            itemView.context.getString(R.string.text_priority),
            task.priority.toString()
        )

        task.apply {
            imgEmployee?.let { img ->
                if (img.isNotEmpty()) {
                    Glide.with(itemView)
                        .load(img)
                        .centerCrop()
                        .placeholder(R.mipmap.placeholder)
                        .into(itemView.imgEmployee as ImageView)
                }
            }

            when (state) {
                TaskState.OPEN -> {
                    itemView.setOnClickListener {
                        f(task, itemView)
                    }
                }
                TaskState.CLOSE -> {
                    itemView.clTask.setBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorLigthGrey
                        )
                    )
                }
            }
        }
    }

}