package com.manday.fruit.ui.viewmodel

import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
import com.manday.coredata.utils.transformMap
import com.manday.coredata.utils.transformWhenItChanges
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    /*
    fun getAllFruits() =
        transformWhenItChanges(repository.getAllFruits(CATEGORY, ITEM)) {
        if (it == null)
            HandlerResponseViewModel.createResponse("Se ha producido un error")
        else  {
            HandlerResponseViewModel.createResponse(extra = transformMap(it) {
                it.mapToFruitModel()
            })
        }
    }

     */


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }
}
