package com.manday.coredata.datasource

import com.manday.coredata.entities.FruitEntity

interface FruitDatabaseDataSource {

    fun addFruits(list: List<FruitEntity>)
}