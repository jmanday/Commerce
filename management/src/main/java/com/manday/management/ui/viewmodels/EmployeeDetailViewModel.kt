package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addSourceNotNull
import com.manday.coredata.utils.removeSourceNotNull
import com.manday.management.data.entities.SkillEntity
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.SkillRepository

internal class EmployeeDetailViewModel(
    private val employeeRepository: EmployeeRepository,
    private val skillRepository: SkillRepository
): ExecutorViewModel() {

    private val errorFieldList = mutableListOf<ErrorField>()
    val skills = MediatorLiveData<List<SkillEntity>>()
    lateinit var employeeModel: EmployeeModel

    init {
        skills.addSourceNotNull(skillRepository.getListSkill(), Observer {
            skills.removeSourceNotNull(skillRepository.getListSkill())
            skills.postValue(it)
        })
    }

    fun initialize(employee: EmployeeModel) {
        this.employeeModel = employee
    }

    fun fields(): LiveData<List<ErrorField>> {
        val responseViewModel = MutableLiveData<List<ErrorField>>()

        errorFieldList.clear()
        employeeModel.let {
            if (it.name.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_NAME)
            if (it.surname.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SURNAME)
            if (it.phone.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_PHONE)
            if (it.email.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_EMAIL)
            if (it.country.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_COUNTRY)
            if (it.skillEmployeeDescription.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SKILL)
        }

        responseViewModel.postValue(errorFieldList)

        return responseViewModel
    }

    fun buttonSaveClicked() =
        doInBackgroundAndReturn({
            employeeRepository.addEmployee(employeeModel)
        })


    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_COUNTRY, ERROR_FIELD_SKILL
    }
}

