package com.sdos.commerce.ui.viewholders

import android.view.View
import com.manday.coredata.entities.FruitEntity
import com.manday.coreui.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.list_fruit_item_view.view.*

class FruitViewHolder(itemView: View): BaseViewHolder<FruitEntity>(itemView) {

    override fun onBind(t: FruitEntity, f: (t: FruitEntity) -> Unit) {
        itemView.name.text = t.farmName
        itemView.category.text = t.category
        itemView.item.text = t.item
        itemView.businness.text = t.business
    }
}