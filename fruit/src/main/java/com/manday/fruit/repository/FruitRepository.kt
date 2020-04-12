package com.manday.fruit.repository

import androidx.lifecycle.LiveData
import com.manday.fruit.entities.FruitEntity

interface FruitRepository {

    fun getAllFruits(category: String, item: String): LiveData<List<FruitEntity>>?

    //fun getLocalAllFruits(): LiveData<List<FruitEntity>>

    //fun saveFruits(list: List<FruitEntity>)
}