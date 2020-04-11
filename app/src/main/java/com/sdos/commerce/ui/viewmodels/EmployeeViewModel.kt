package com.sdos.commerce.ui.viewmodels


import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.ResponseViewModelEntity
import com.sdos.commerce.repositories.EmployeeRepository
import com.sdos.commerce.util.transformWhenItChanges

class EmployeeViewModel(
    val employeeRepository: EmployeeRepository) : ExecutorViewModel() {

    private val listEmployees = MutableLiveData<List<EmployeeEntity>>()

    fun getEmployees() =
        transformWhenItChanges(employeeRepository.getEmployees()) {
            listEmployees.value = it
            if (it == null)
                ResponseViewModelEntity.createResponse("Se ha producido un error")
            else
                ResponseViewModelEntity.createResponse(extra = it)
        }

}
