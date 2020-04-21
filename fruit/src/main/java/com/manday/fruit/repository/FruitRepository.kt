package com.manday.fruit.repository

import androidx.lifecycle.LiveData
import com.manday.fruit.entities.FruitEntity
import com.manday.fruit.models.FruitModel

interface FruitRepository {

    fun getAllFruits(category: String, item: String): LiveData<List<FruitModel>?>?

    //fun getLocalAllFruits(): LiveData<List<FruitEntity>>

    //fun saveFruits(list: List<FruitEntity>)
}