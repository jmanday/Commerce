package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.FruitEntity

interface FruitRepository {

    fun getAllFruits(category: String, item: String): LiveData<List<FruitEntity>>
}