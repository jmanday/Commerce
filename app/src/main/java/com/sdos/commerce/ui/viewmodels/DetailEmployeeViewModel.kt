package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.entities.Skill
import com.sdos.commerce.listeners.ViewModelListener
import com.sdos.commerce.ui.fragments.DetailEmployeeFragment
import com.sdos.commerce.util.ExecutorViewModel
import com.sdos.commerce.util.isDateValidate

class DetailEmployeeViewModel: ExecutorViewModel() {

    private lateinit var view: DetailEmployeView
    private lateinit var baseView: ViewModelListener
    private val skills = MediatorLiveData<List<Skill>>()
    private val employees = MediatorLiveData<List<Employee>>()
    private val getListSkillInteractor =  (CommerceApp.getInstance() as DomainInjector).provideGetListSkillInteractor()
    private val addEmployeeInteractor =  (CommerceApp.getInstance() as DomainInjector).provideAddEmployeeInteractor()

    fun init(view: DetailEmployeView) {
        this.view = view
        this.baseView = view as ViewModelListener
        getListSkillInteractor.invoke()?.let {source ->
            skills.addSource(source, Observer{
                skills.removeSource(source)
                skills.value = it
            })
        }
    }

    fun onButtonAddClicked(employee: Employee) {
        val errorFieldList = mutableListOf<DetailEmployeeFragment.ErrorField>()

        employee.let {
            if (it.name.isEmpty()) errorFieldList.add(DetailEmployeeFragment.ErrorField.ERROR_FIELD_NAME)
            if (it.surname.isEmpty()) errorFieldList.add(DetailEmployeeFragment.ErrorField.ERROR_FIELD_SURNAME)
            if (it.email.isEmpty()) errorFieldList.add(DetailEmployeeFragment.ErrorField.ERROR_FIELD_EMAIL)
            if (it.phone.isEmpty()) errorFieldList.add(DetailEmployeeFragment.ErrorField.ERROR_FIELD_PHONE)
            if (it.pass.isEmpty()) errorFieldList.add(DetailEmployeeFragment.ErrorField.ERROR_FIELD_PASS)
            if (it.birthdate.isDateValidate() || it.birthdate.isEmpty()) errorFieldList.add(
                DetailEmployeeFragment.ErrorField.ERROR_FIELD_DATE)
        }

        if (errorFieldList.isEmpty()) {
            doFirstInBackground({
                addEmployeeInteractor.invoke(employee)
            }, {
                baseView.showMessage("Empleado añadido correctamente")
            })
        }
        else
            view.showError(errorFieldList)
    }

    fun getListSkills() = skills

    fun getEmployees() = employees


    interface DetailEmployeView {
        fun showError(errorFieldList: List<DetailEmployeeFragment.ErrorField>)
    }
}

