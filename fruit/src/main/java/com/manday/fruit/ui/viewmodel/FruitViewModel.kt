package com.manday.fruit.ui.viewmodel

import com.manday.coredata.ExecutorViewModel
import com.manday.fruit.repository.FruitRepository
import org.koin.java.KoinJavaComponent.inject

class FruitViewModel : ExecutorViewModel() {

    private val repository: FruitRepository by inject(FruitRepository::class.java)

    fun fruits() =
        doInBackground {
            repository.getAllFruits(CATEGORY, ITEM)
        }


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }

}
