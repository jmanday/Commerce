package com.manday.fruit.repository

import com.manday.coredata.utils.addMultipleDataSource
import com.manday.fruit.datasource.database.FruitDatabaseDataSource
import com.manday.fruit.datasource.net.FruitNetDataSource
import com.manday.fruit.entities.mapToListFruitModel

class FruitRepositoryImpl(
    private val netDataSource: FruitNetDataSource,
    private val databaseDataSource: FruitDatabaseDataSource
): FruitRepository {

    override fun getAllFruits(category: String, item: String) =
        addMultipleDataSource(
            netDataSource.getFruits(category, item),
            databaseDataSource.getAllLocalFruits(),
            {
                databaseDataSource.addFruits(it)
            },
            {
                it?.mapToListFruitModel()
            }
        )
}