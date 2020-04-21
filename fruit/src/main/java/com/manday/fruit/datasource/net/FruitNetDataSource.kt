package com.manday.fruit.datasource.net

import androidx.lifecycle.LiveData
import com.manday.fruit.entities.FruitEntity

interface FruitNetDataSource {

    fun getFruits(category: String, item: String): LiveData<List<FruitEntity>>?
}