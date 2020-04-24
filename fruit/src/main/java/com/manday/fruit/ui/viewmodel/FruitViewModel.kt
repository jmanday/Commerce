package com.manday.fruit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addSourceNotNull
import com.manday.coredata.utils.removeSourceNotNull
import com.manday.fruit.models.FruitModel
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    private val fruitsList = MediatorLiveData<List<FruitModel>?>()

    fun fruits(): LiveData<List<FruitModel>?> {
        fruitsList.addSourceNotNull(repository.getAllFruits(CATEGORY, ITEM), Observer<List<FruitModel>?> {
            fruitsList.removeSourceNotNull(repository.getAllFruits(CATEGORY, ITEM))
            fruitsList.postValue(it)
        })

        return fruitsList
    }


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }

}
