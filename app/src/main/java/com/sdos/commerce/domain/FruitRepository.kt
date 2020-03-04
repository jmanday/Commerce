package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Fruit

interface FruitRepository {

    fun getAllFruits(category: String, item: String): LiveData<List<Fruit>>

    fun addFruits(fruits: List<Fruit>)
}