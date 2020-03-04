package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.models.FruitModel

interface FruitRepository {

    fun getAllFruits(category: String, item: String): LiveData<List<FruitModel>>
}