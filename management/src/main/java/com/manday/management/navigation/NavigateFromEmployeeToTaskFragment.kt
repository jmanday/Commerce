package com.manday.management.navigation

import android.view.View
import com.manday.coredata.navigation.Navigate
import com.manday.management.domain.EmployeeAdapterModel
import com.manday.management.ui.fragments.EmployeeFragmentDirections

class NavigateFromEmployeeToTaskFragment : Navigate<EmployeeAdapterModel> {

    override fun navigate(itemView: View?, employeeItemAdapter: EmployeeAdapterModel?) {
        val action = EmployeeFragmentDirections.actionEmployeeFragmentToTaskFragment()

        Navigate.navController?.navigate(action)
    }
}