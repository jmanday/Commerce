package com.sdos.commerce.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.manday.coredata.ExecutorViewModel
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.domain.interactors.GetEmployeesInteractor

class EmployeeFragmentViewModel(val getEmployeesInteractor: GetEmployeesInteractor) : ExecutorViewModel() {

    private var employeeList = MutableLiveData<List<EmployeeEntity>>()

    fun getEmployees(): MutableLiveData<List<EmployeeEntity>> {
        doFirstInBackgroundWithResult({
            getEmployeesInteractor.invoke()
        }, {
            employeeList.value = it
        })

        return employeeList
    }
}
