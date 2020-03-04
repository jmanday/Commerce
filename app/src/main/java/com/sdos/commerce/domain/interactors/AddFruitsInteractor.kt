package com.sdos.commerce.domain.interactors

import com.sdos.commerce.domain.FruitRepository
import com.sdos.commerce.entities.Fruit

class AddFruitsInteractor(private val repository: FruitRepository): (List<Fruit>) -> Unit {

    override fun invoke(list: List<Fruit>) {
        repository.addFruits(list)
    }
}