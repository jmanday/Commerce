package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.models.Fruit
import com.sdos.commerce.domain.FruitRepository

class GetAllFruitsInteractor(private val repository: FruitRepository): (String, String) -> LiveData<List<Fruit>> {

    override fun invoke(category: String, item: String): LiveData<List<Fruit>> {
        return repository.getAllFruits(category, item)
    }
}