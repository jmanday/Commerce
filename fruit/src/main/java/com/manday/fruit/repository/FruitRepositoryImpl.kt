package com.manday.fruit.repository

import com.manday.coredata.utils.transformationsNotNull
import com.manday.fruit.datasource.net.FruitNetDataSource

class FruitRepositoryImpl(
    private val dataSource: FruitNetDataSource
): FruitRepository {

    override fun getAllFruits(category: String, item: String) =
        transformationsNotNull(dataSource.getFruits(category, item)){
            it.map { it.mapToFruitModel() }
        }
}