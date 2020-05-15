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

    override fun navigate(itemView: View?, t: EmployeeModel?) {
        var localTransitionName = NAME_GENERAL_TRANSITION
        var extras: FragmentNavigator.Extras = FragmentNavigatorExtras()

        if (t != null) {
            localTransitionName = t.name
        }

        if (itemView != null) {
            itemView.transitionName = localTransitionName
            extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        }

        val action = EmployeeFragmentDirections.actionMainFragmentToDetailEmployeeFragment(
            t,
            localTransitionName
        )

        navController?.navigate(action, extras)
    }

}