package com.manday.fruit.ui.viewholder

import android.view.View
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.fruit.models.FruitModel
import kotlinx.android.synthetic.main.list_fruit_item_view.view.*

internal class FruitViewHolder(itemView: View): BaseViewHolder<FruitModel>(itemView) {

    override fun onBind(t: FruitModel, f: (t: FruitModel) -> Unit) {
        itemView.name.text = t.farmName
        itemView.category.text = t.category
        itemView.businness.text = t.business
    }
}