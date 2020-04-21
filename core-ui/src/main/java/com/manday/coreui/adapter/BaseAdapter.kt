package com.manday.coreui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manday.coreui.viewholder.BaseViewHolder

abstract class BaseAdapter<T, VH: BaseViewHolder<T>>(private val listT: List<T>, private val listener: (T, View) -> Unit): RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int {
        return listT.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return generateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listT.get(position), listener)
    }

    abstract fun generateViewHolder(parent: ViewGroup, viewType: Int): VH
}