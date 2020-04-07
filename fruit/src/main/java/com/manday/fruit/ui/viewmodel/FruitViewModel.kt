package com.manday.fruit.ui.viewmodel

import androidx.lifecycle.LiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.FruitEntity
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    fun getAllFruits(): LiveData<List<FruitEntity>> {
        return repository.getAllFruits(CATEGORY, ITEM)
    }

    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }
}