package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.ResponseViewModelEntity
import com.sdos.commerce.repositories.EmployeeRepository
import com.sdos.commerce.repositories.SkillRepository
import com.sdos.commerce.listeners.ViewModelListener
import com.sdos.commerce.util.isDateValidate

class DetailEmployeeViewModel(
    private val employeeRepository: EmployeeRepository,
    private val skillRepository: SkillRepository
): ExecutorViewModel() {

    private val errorFieldList = mutableListOf<ErrorField>()
    private val responseViewModelEntity = MutableLiveData<ResponseViewModelEntity<ErrorField>>()

    fun onButtonAddClicked(employee: EmployeeEntity): LiveData<ResponseViewModelEntity<ErrorField>> {
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
                responseViewModelEntity.value = ResponseViewModelEntity.createResponse("Empleado añadido correctamente")
            })
        }
        else {
            responseViewModelEntity.value =
                ResponseViewModelEntity.createResponse("Campo incorrecto", null, errorFieldList)
        }

        return responseViewModelEntity
    }

    fun getListSkills() = skillRepository.getListSkill()

    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_DATE, ERROR_FIELD_PASS
    }
}

