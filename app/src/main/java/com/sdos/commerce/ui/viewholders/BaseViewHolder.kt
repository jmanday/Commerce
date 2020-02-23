package com.sdos.commerce.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    open fun onBind(t: T) {}
}