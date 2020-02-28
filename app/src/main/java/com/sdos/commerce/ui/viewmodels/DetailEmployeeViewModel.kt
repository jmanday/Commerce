package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.entities.Skill

class DetailEmployeeViewModel: ViewModel() {

    private val skills = MediatorLiveData<List<Skill>>()
    private val employees = MediatorLiveData<List<Employee>>()

    val getListSkillInteractor =  (CommerceApp.getInstance() as DomainInjector).provideGetListSkillInteractor()
    val addEmployeeinteractor =  (CommerceApp.getInstance() as DomainInjector).provideGetListSkillInteractor()

    fun init() {
        getListSkillInteractor.invoke()?.let {source ->
            skills.addSource(source, Observer{
                skills.removeSource(source)
                skills.value = it
            })
        }
    }

    fun getListSkills() = skills
}