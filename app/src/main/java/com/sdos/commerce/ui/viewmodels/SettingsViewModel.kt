package com.sdos.commerce.ui.viewmodels

import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.util.ExecutorViewModel

class SettingsViewModel(
    private val fruitRepository: FruitRepository
): ExecutorViewModel() {

    fun getFruits(category: String, item: String) = fruitRepository.getAllFruits(category, item)
}