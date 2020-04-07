package com.sdos.commerce.ui.viewmodels

import com.manday.coredata.ExecutorViewModel
import com.sdos.commerce.repositories.FruitRepository

class SettingsViewModel(
    private val fruitRepository: FruitRepository
): ExecutorViewModel() {

    fun getFruits(category: String, item: String) = fruitRepository.getAllFruits(category, item)
}