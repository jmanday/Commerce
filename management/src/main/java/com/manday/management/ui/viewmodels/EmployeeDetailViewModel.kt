package com.manday.management.ui.viewmodels

import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.HandlerResponseViewModel
import com.manday.management.data.entities.EmployeeEntity
import com.manday.management.domain.EmployeeModel
import com.manday.management.isDateValidate
import com.manday.management.repository.EmployeeRepository

internal class EmployeeDetailViewModel(
    private val employeeRepository: EmployeeRepository
): ExecutorViewModel() {

    private val errorFieldList = mutableListOf<ErrorField>()
    private lateinit var responseViewModelEntity: HandlerResponseViewModel<List<ErrorField>>
    private var employeeModel: EmployeeModel? = null

    fun initialize(employee: EmployeeModel) {
        this.employeeModel = employeeModel
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

