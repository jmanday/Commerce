package com.sdos.commerce.data.datasource

import com.sdos.commerce.entities.Fruit

interface FruitDatabaseDataSource {

    fun addFruits(list: List<Fruit>)
}