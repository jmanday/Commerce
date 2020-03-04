package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.entities.Fruit

class GetAllFruitsInteractor(private val repository: FruitRepository): (String, String) -> LiveData<List<Fruit>> {

    override fun invoke(category: String, item: String): LiveData<List<Fruit>> {
        return repository.getAllFruits(category, item)
    }
}