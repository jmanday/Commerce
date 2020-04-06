package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.FruitNetDataSource
import com.manday.coredata.entities.FruitEntity

class FruitRepositoryImpl(
    private val dataSource: FruitNetDataSource
): FruitRepository {

    override fun getAllFruits(category: String, item: String): LiveData<List<FruitEntity>> {
        return dataSource.getFruits(category, item)
    }
}