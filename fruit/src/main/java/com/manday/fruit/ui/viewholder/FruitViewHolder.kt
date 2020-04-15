package com.manday.fruit.ui.viewholder

import android.view.View
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.fruit.models.FruitModel
import kotlinx.android.synthetic.main.list_fruit_item_view.view.*

internal class FruitViewHolder(itemView: View): BaseViewHolder<FruitModel>(itemView) {

    override fun onBind(fruitModel: FruitModel, f: (t: FruitModel) -> Unit) {
        itemView.name.text = fruitModel.farmName
        itemView.category.text = fruitModel.category
        itemView.businness.text = fruitModel.business

        itemView.setOnClickListener {
            f(fruitModel)
        }
    }
}