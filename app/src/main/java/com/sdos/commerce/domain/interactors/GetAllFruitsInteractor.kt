package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.models.FruitModel
import com.sdos.commerce.domain.FruitRepository

class GetAllFruitsInteractor(private val repository: FruitRepository): (String, String) -> LiveData<List<FruitModel>> {

    override fun invoke(category: String, item: String): LiveData<List<FruitModel>> {
        return repository.getAllFruits(category, item)
    }
}