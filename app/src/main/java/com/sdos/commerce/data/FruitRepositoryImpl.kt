package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.FruitDatabaseDataSource
import com.sdos.commerce.data.datasource.FruitNetDataSource
import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.entities.Fruit

class FruitRepositoryImpl(private val netDatasource: FruitNetDataSource,
                          private val databaseDatasource: FruitDatabaseDataSource): FruitRepository {

    override fun getAllFruits(category: String, item: String): LiveData<List<Fruit>> {
        return netDatasource.getFruits(category, item)
    }

    override fun addFruits(fruits: List<Fruit>) {
        databaseDatasource.addFruits(fruits)
    }
}