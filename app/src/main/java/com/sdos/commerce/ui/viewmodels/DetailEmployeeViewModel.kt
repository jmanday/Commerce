package com.sdos.commerce.ui.viewmodels

import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.domain.interactors.EmployeeRepository
import com.sdos.commerce.domain.interactors.SkillRepository
import com.sdos.commerce.listeners.ViewModelListener
import com.sdos.commerce.util.isDateValidate

class DetailEmployeeViewModel(
    private val employeeRepository: EmployeeRepository,
    private val skillRepository: SkillRepository
): ExecutorViewModel() {

    private lateinit var view: DetailEmployeView
    private lateinit var baseView: ViewModelListener

    fun init(view: DetailEmployeView) {
        this.view = view
        this.baseView = view as ViewModelListener
    }

    fun onButtonAddClicked(employee: EmployeeEntity) {
        val errorFieldList = mutableListOf<ErrorField>()

        employee.let {
            if (it.name.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_NAME)
            if (it.surname.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SURNAME)
            if (it.email.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_EMAIL)
            if (it.phone.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_PHONE)
            if (it.pass.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_PASS)
            if (it.birthdate.isDateValidate() || it.birthdate.isEmpty()) errorFieldList.add(
                ErrorField.ERROR_FIELD_DATE)
        }

        if (errorFieldList.isEmpty()) {
            doFirstInBackground({
                employeeRepository.addEmployee(employee)
            }, {
                view.showError(emptyList(), "Empleado añadido correctamente")
            })
        }
        else
            view.showError(errorFieldList, "Campo incorrecto")
    }

    fun getListSkills() = skillRepository.getListSkill()

    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_DATE, ERROR_FIELD_PASS
    }

    interface DetailEmployeView {
        fun showError(errorFieldList: List<ErrorField>, msg: String)
    }
}

