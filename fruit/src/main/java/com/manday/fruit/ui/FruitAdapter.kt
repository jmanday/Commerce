package com.manday.fruit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.manday.coredata.entities.FruitEntity
import com.manday.coreui.adapter.BaseAdapter
import com.manday.fruit.R

internal class FruitAdapter(list: List<FruitEntity>, listener: (FruitEntity) -> Unit): BaseAdapter<FruitEntity, FruitViewHolder>(list, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_fruit_item_view, parent, false)
        return FruitViewHolder(itemView)
    }
}