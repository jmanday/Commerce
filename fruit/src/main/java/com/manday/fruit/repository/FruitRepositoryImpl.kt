package com.manday.fruit.repository

import androidx.lifecycle.LiveData
import com.manday.fruit.entities.FruitEntity
import com.manday.fruit.datasource.net.FruitNetDataSource

class FruitRepositoryImpl(
    private val dataSource: FruitNetDataSource
): FruitRepository {

    override fun getAllFruits(category: String, item: String): LiveData<List<FruitEntity>>? {
        return dataSource.getFruits(category, item)
    }
}