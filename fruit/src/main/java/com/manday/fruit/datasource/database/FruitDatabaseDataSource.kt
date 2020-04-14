package com.manday.fruit.datasource.database

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.FruitEntity

interface FruitDatabaseDataSource {

    fun addFruits(list: List<com.manday.management.data.entities.FruitEntity>)

    fun getAllLocalFruits(): LiveData<List<com.manday.management.data.entities.FruitEntity>>
}