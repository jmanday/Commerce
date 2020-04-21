package com.manday.fruit.ui.viewmodel

import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
import com.manday.coredata.utils.transformMap
import com.manday.coredata.utils.transformWhenItChanges
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    fun getAllFruits() =
        HandlerResponseViewModel.createResponse(repository.getAllFruits(CATEGORY, ITEM))


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }
}
