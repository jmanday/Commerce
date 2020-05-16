package com.manday.management.navigation

import android.view.View
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.manday.coredata.navigation.Navigate
import com.manday.coredata.navigation.Navigate.Companion.navController
import com.manday.management.Constants.NAME_GENERAL_TRANSITION
import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.fragments.EmployeeFragmentDirections

open class NavigateFromEmployeeToDetailFragment : Navigate<EmployeeModel> {

    override fun navigate(itemView: View?, employeeModel: EmployeeModel?) {
        var localTransitionName = NAME_GENERAL_TRANSITION
        var extras: FragmentNavigator.Extras = FragmentNavigatorExtras()

        employeeModel?.let {
            localTransitionName = it.name
        }

        itemView?.let {
            it.transitionName = localTransitionName
            extras = FragmentNavigatorExtras(it to it.transitionName)
        }

        val action = EmployeeFragmentDirections.actionMainFragmentToDetailEmployeeFragment(
            employeeModel,
            localTransitionName
        )

        navController?.navigate(action, extras)
    }

}