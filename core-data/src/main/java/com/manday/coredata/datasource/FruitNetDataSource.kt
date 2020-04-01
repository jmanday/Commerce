package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.FruitEntity

interface FruitNetDataSource {

    fun getFruits(category: String, item: String): LiveData<List<FruitEntity>>
}