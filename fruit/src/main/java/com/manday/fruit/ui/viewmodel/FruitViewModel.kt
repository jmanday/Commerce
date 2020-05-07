package com.manday.fruit.ui.viewmodel

import com.manday.coredata.ExecutorViewModel
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    fun fruits() =
        doInBackground {
            repository.getAllFruits(CATEGORY, ITEM)
        }


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }

}
