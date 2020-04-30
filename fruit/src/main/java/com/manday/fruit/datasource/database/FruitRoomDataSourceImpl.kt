package com.manday.fruit.datasource.database

import androidx.lifecycle.LiveData
import com.manday.fruit.controllers.FruitRoomController
import com.manday.fruit.dao.FruitDao
import com.manday.fruit.entities.FruitEntity

class FruitRoomDataSourceImpl : FruitDatabaseDataSource {

    private var fruitDao: FruitDao? = null

    init {
        fruitDao = FruitRoomController.getInstance()?.fruitDao()
    }

    override fun getAllLocalFruits(): LiveData<List<FruitEntity>?>? {
        return fruitDao?.getAllFruits()
    }

    override fun addFruits(list: List<FruitEntity>) {
        fruitDao?.insert(list)
    }
}