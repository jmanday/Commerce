package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Fruit
import com.sdos.commerce.util.ExecutorViewModel

class SettingsViewModel: ExecutorViewModel() {

    private val fruits = MediatorLiveData<List<Fruit>>()
    private val getFruitsInteractor = (CommerceApp.getInstance() as DomainInjector).provideGetAllFruitsInteractor()
    private val addFruitsInteractor = (CommerceApp.getInstance() as DomainInjector).provideAddFruitsInteractor()

    fun getFruits(category: String, item: String): MediatorLiveData<List<Fruit>> {
        getFruitsInteractor.invoke(category, item).let { source ->
            fruits.addSource(source, Observer {
                fruits.removeSource(source)
                fruits.value = it
                doInBackgroundAndWait {
                    addFruitsInteractor.invoke(it)
                }
            })
        }
        return fruits
    }
}