package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
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
    private lateinit var responseViewModelEntity: HandlerResponseViewModel<List<ErrorField>>
    var employeeModel: EmployeeModel? = null
    private var skills = MediatorLiveData<List<SkillEntity>>()

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


    fun onButtonAddClicked(employee: EmployeeModel): HandlerResponseViewModel<List<ErrorField>> {
        employee.let {
            if (it.name.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_NAME)
            if (it.surname.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_SURNAME)
            if (it.email.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_EMAIL)
            //if (it.phone.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_PHONE)
            //if (it.pass.isEmpty()) errorFieldList.add(ErrorField.ERROR_FIELD_PASS)
            //if (it.birthdate.isDateValidate() || it.birthdate.isEmpty()) errorFieldList.add(
              //  ErrorField.ERROR_FIELD_DATE
            //)
        }

        /*
        if (errorFieldList.isEmpty()) {
            doFirstInBackground({
                employeeRepository.addEmployee(employee)
            }, {
                responseViewModelEntity = HandlerResponseViewModel.createResponse("Empleado añadido correctamente")
            })
        }
        else {
            responseViewModelEntity =
                HandlerResponseViewModel.createResponse("Campo incorrecto", errorFieldList)
        }

         */

        return responseViewModelEntity
    }

    //fun getListSkills() = skillRepository.getListSkill()

    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_DATE, ERROR_FIELD_PASS
    }
}

