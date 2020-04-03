package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.manday.coredata.entities.SkillEntity
import com.sdos.commerce.domain.interactors.AddEmployeeInteractor
import com.sdos.commerce.domain.interactors.GetListSkillInteractor
import com.sdos.commerce.listeners.ViewModelListener
import com.sdos.commerce.ui.fragments.DetailEmployeeFragment
import com.sdos.commerce.util.isDateValidate

class DetailEmployeeViewModel(
    private val getListSkillInteractor: GetListSkillInteractor,
    private val addEmployeeInteractor: AddEmployeeInteractor
): ExecutorViewModel() {

    private lateinit var view: DetailEmployeView
    private lateinit var baseView: ViewModelListener
    private val skills = MediatorLiveData<List<SkillEntity>>()
    private val skillsLiveData = MutableLiveData<List<SkillEntity>>()
    private val employees = MediatorLiveData<List<EmployeeEntity>>()

    init {

    }

    fun init(view: DetailEmployeView) {
        this.view = view
        this.baseView = view as ViewModelListener
        doFirstInBackgroundWithResult({
            getListSkillInteractor.invoke()
        }, {
            it?.let {source ->
                skillsLiveData.value = source
                skills.addSource(skillsLiveData, Observer{
                    skills.removeSource(skillsLiveData)
                    skills.value = it
                })
            }
        })
    }

    fun onButtonAddClicked(employee: EmployeeEntity) {
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

