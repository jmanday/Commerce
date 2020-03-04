package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.FruitDataSource
import com.sdos.commerce.data.models.FruitModel
import com.sdos.commerce.domain.FruitRepository

class FruitRepositoryImpl(private val datasource: FruitDataSource): FruitRepository {

    override fun getAllFruits(category: String, item: String): LiveData<List<FruitModel>> {
        return datasource.getFruits(category, item)
    }
}