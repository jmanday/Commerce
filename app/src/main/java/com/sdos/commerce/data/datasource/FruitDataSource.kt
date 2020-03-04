package com.sdos.commerce.data.datasource

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.models.FruitModel

interface FruitDataSource {

    fun getFruits(category: String, item: String): LiveData<List<FruitModel>>
}