package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addMultipleSourceNotNull
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.SkillRepository

internal class EmployeeViewModel(
    val employeeRepository: EmployeeRepository,
    val skillRepository: SkillRepository
) : ExecutorViewModel() {

    private val employees = MutableLiveData<List<EmployeeModel>?>()

    fun employees(): LiveData<List<EmployeeModel>?> {
        addMultipleSourceNotNull(employeeRepository.getEmployees(), skillRepository.getListSkill()) { listEmployees, listSkills ->
            listEmployees?.map {
                it.typeEmployeeDescription = listSkills?.find { skill ->
                    skill.id == it.typeEmployee
                }?.name ?: ""
            }
            employees.postValue(listEmployees)
        }

        return employees
    }

}
