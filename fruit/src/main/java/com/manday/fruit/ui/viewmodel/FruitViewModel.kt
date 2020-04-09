package com.manday.fruit.ui.viewmodel


import android.util.Log
import androidx.lifecycle.*
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.FruitEntity
import com.manday.fruit.repository.FruitRepository

class FruitViewModel(
    private val repository: FruitRepository
): ExecutorViewModel() {

    val fruits = MediatorLiveData<List<FruitEntity>>()

    fun getAllFruits(): LiveData<List<FruitEntity>> {
        fruits.addSource(repository.getAllFruits(CATEGORY, ITEM), object : Observer<List<FruitEntity>>{
            override fun onChanged(t: List<FruitEntity>?) {
                doInBackground {
                    fruits.removeSource(repository.getAllFruits(CATEGORY, ITEM))
                    fruits.postValue(t)
                }
            }
        })

        return fruits
    }


    companion object {
        const val CATEGORY = "Fruit"
        const val ITEM = "Peaches"
    }
}
