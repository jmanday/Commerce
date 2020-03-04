package com.sdos.commerce.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sdos.commerce.R
import com.sdos.commerce.entities.Fruit
import com.sdos.commerce.ui.viewholders.FruitViewHolder

class FruitAdapter(list: List<Fruit>, listener: (Fruit) -> Unit): BaseAdapter<Fruit, FruitViewHolder>(list, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_fruit_item_view, parent, false)
        return FruitViewHolder(itemView)
    }
}