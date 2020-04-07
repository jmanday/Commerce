package com.manday.fruit.datasource.database

import com.manday.coredata.entities.FruitEntity

interface FruitDatabaseDataSource {

    fun addFruits(list: List<FruitEntity>)
}