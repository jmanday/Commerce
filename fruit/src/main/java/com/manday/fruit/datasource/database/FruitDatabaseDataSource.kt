package com.manday.fruit.datasource.database

import androidx.lifecycle.LiveData
import com.manday.fruit.entities.FruitEntity

interface FruitDatabaseDataSource {

    fun addFruits(list: List<FruitEntity>)

    fun getAllLocalFruits(): LiveData<List<FruitEntity>>
}