package com.manday.management.navigation

import com.manday.coredata.navigation.AutoNavigate
import com.manday.coredata.navigation.Navigate
import com.manday.management.domain.EmployeeAdapterModel
import com.manday.management.ui.fragments.EmployeeFragmentDirections

class NavigateFromEmployeeToTaskFragment : AutoNavigate<EmployeeAdapterModel> {

    override fun navigate(t: EmployeeAdapterModel?) {
        val action = EmployeeFragmentDirections.actionEmployeeFragmentToTaskFragment()

        Navigate.navController?.navigate(action)
    }
}