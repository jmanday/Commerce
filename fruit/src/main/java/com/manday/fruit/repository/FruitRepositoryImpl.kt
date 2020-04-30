package com.manday.fruit.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.utils.addMultipleDataSource
import com.manday.fruit.datasource.database.FruitDatabaseDataSource
import com.manday.fruit.datasource.net.FruitNetDataSource
import com.manday.fruit.entities.mapToFruitModel
import com.manday.fruit.models.FruitModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FruitRepositoryImpl(
    private val netDataSource: FruitNetDataSource,
    private val databaseDataSource: FruitDatabaseDataSource
): FruitRepository {

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun getAllFruits(category: String, item: String): LiveData<List<FruitModel>?> {
        val listFruitModel = mutableListOf<FruitModel>()

        return addMultipleDataSource(
            netDataSource.getFruits(category, item),
            databaseDataSource.getAllLocalFruits(),
            {
                scope.launch {
                    databaseDataSource.addFruits(it)
                }
            },
            {
                it.forEach {
                    if (it.isEnabled())
                        listFruitModel.add(it.mapToFruitModel())
                }

                listFruitModel.toList()
            })
    }
}