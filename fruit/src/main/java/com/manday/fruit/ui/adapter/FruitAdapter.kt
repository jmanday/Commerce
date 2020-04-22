package com.manday.fruit.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coreui.adapter.BaseAdapter
import com.manday.fruit.R
import com.manday.fruit.models.FruitModel
import com.manday.fruit.ui.viewholder.FruitViewHolder

internal class FruitAdapter(list: List<FruitModel>, listener: (FruitModel, View) -> Unit): BaseAdapter<FruitModel, FruitViewHolder>(list, listener) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_fruit_item_view, parent, false)
        return FruitViewHolder(itemView)
    }
}