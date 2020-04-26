package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
import com.manday.coredata.ResponseFormViewModel
import com.manday.coredata.utils.addSourceNotNull
import com.manday.coredata.utils.removeSourceNotNull
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.data.entities.SkillEntity
import com.manday.management.domain.EmployeeModel
import com.manday.management.isDateValidate
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.SkillRepository

internal class EmployeeDetailViewModel(
    private val employeeRepository: EmployeeRepository,
    private val skillRepository: SkillRepository
): ExecutorViewModel() {

    private val errorFieldList = mutableListOf<ErrorField>()
    private var skills = MediatorLiveData<List<SkillEntity>>()
    lateinit var employeeModel: EmployeeModel

    fun initialize(employee: EmployeeModel) {
        this.employeeModel = employee
    }

    fun skills(): LiveData<List<SkillEntity>> {
        skills.addSourceNotNull(skillRepository.getListSkill(), Observer {
            skills.removeSourceNotNull(skillRepository.getListSkill())
            skills.postValue(it)
        })

        return skills
    }


    fun buttonSaveClicked(): LiveData<ResponseFormViewModel<List<ErrorField>>> {
        val responseViewModel = MutableLiveData<ResponseFormViewModel<List<ErrorField>>>()
        errorFieldList.clear()
        employeeModel.let {
            if (it.name.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_NAME)
            if (it.surname.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SURNAME)
            if (it.email.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_EMAIL)
            if (it.country.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_COUNTRY)
            if (it.skillEmployeeDescription.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SKILL)
        }

        if (errorFieldList.isEmpty()) {
            doInBackgroundAndContinue({
                employeeModel.let {
                    employeeRepository.addEmployee(it)
                }
            }, {
                responseViewModel.postValue(HandlerResponseViewModel.createResponseForm("Los cambios han sido guardados"))
            })
        }
        else
            responseViewModel.postValue(HandlerResponseViewModel.createResponseForm("Campo vacío", resp = errorFieldList))

        return responseViewModel
    }


    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_COUNTRY, ERROR_FIELD_SKILL
    }
}

