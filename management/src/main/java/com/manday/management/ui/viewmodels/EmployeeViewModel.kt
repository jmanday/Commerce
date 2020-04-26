package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.utils.addMultipleSourceNotNull
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.SkillRepository

internal class EmployeeViewModel(
    employeeRepository: EmployeeRepository,
    skillRepository: SkillRepository
) : ExecutorViewModel() {

    val employees = MutableLiveData<List<EmployeeModel>?>()

    init {
        addMultipleSourceNotNull(employeeRepository.getEmployees(), skillRepository.getListSkill()) { listEmployees, listSkills ->
            listEmployees?.map {
                it.skillEmployeeDescription = listSkills?.find { skill ->
                    skill.id == it.skillEmployee
                }?.name ?: ""
            }
            employees.postValue(listEmployees)
        }
    }

}
