package com.manday.management.navigation

import android.view.View
import com.manday.coredata.navigation.Navigate
import com.manday.management.ui.adapters.EmployeeItemAdapter
import com.manday.management.ui.fragments.EmployeeFragmentDirections

class NavigateFromEmployeeToTaskFragment : Navigate<EmployeeItemAdapter> {

    override fun navigate(itemView: View?, employeeItemAdapter: EmployeeItemAdapter?) {
        val action = EmployeeFragmentDirections.actionEmployeeFragmentToTaskFragment()

        Navigate.navController?.navigate(action)
    }
}