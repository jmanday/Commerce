package com.manday.fruit.ui.viewholder

import android.view.View
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import com.manday.coreui.viewholder.BaseViewHolder
import com.manday.fruit.R
import com.manday.fruit.models.FruitModel
import kotlinx.android.synthetic.main.list_fruit_item_view.view.*

internal class FruitViewHolder(itemView: View): BaseViewHolder<FruitModel>(itemView) {

    override fun onBind(fruitModel: FruitModel, f: (t: FruitModel, v: View) -> Unit) {
        itemView.name.text = fruitModel.farmName
        itemView.category.text = fruitModel.category
        itemView.businness.text = fruitModel.business
        itemView.ivMap.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_google_maps))

        itemView.name.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorWhite))
        itemView.category.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorWhite))
        itemView.businness.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorWhite))
        itemView.ivMap.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorWhite))


        itemView.setOnClickListener {
            f(fruitModel, itemView)
        }
    }
}