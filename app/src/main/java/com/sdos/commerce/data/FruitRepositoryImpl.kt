package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.FruitDataSource
import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.entities.Fruit

class FruitRepositoryImpl(private val datasource: FruitDataSource): FruitRepository {

    override fun getAllFruits(category: String, item: String): LiveData<List<Fruit>> {
        return datasource.getFruits(category, item)
    }
}