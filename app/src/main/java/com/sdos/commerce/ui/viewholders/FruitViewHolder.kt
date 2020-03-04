package com.sdos.commerce.ui.viewholders

import android.view.View
import com.sdos.commerce.entities.Fruit
import kotlinx.android.synthetic.main.list_fruit_item_view.view.*

class FruitViewHolder(itemView: View): BaseViewHolder<Fruit>(itemView) {

    override fun onBind(t: Fruit, f: (t: Fruit) -> Unit) {
        itemView.name.text = t.farmName
        itemView.category.text = t.category
        itemView.item.text = t.item
        itemView.businness.text = t.business
    }
}