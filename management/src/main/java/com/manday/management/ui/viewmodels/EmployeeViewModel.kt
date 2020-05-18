package com.manday.management.ui.viewmodels

import androidx.lifecycle.LiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.management.domain.EmployeeModel
import com.manday.management.repository.EmployeeRepository
import com.manday.management.repository.SkillRepository
import org.koin.java.KoinJavaComponent.inject


internal class EmployeeViewModel : ExecutorViewModel() {

    private val employeeRepository: EmployeeRepository by inject(EmployeeRepository::class.java)
    private val skillRepository: SkillRepository by inject(SkillRepository::class.java)
    var employees: LiveData<List<EmployeeModel>?>

    init {
        employees = doBothInBackgroundAndMap(
            {
                employeeRepository.getEmployees()
            }, {
                skillRepository.getListSkill()
            },
            { listEmployees, listSkills ->
                listEmployees?.map {
                    it.skillEmployeeDescription = listSkills?.find { skill ->
                        skill.id == it.skillEmployee
                    }?.name ?: ""
                }

                listEmployees
            }
        )
    }

}
