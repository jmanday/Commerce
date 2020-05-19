package com.manday.management.navigation

import android.view.View
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.manday.coredata.navigation.MotionNavigate
import com.manday.coredata.navigation.Navigate.Companion.navController
import com.manday.management.Constants.NAME_GENERAL_TRANSITION
import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.fragments.EmployeeFragmentDirections

internal class NavigateFromEmployeeToDetailFragment : MotionNavigate<EmployeeModel> {

    override fun navigate(itemView: View, employeeModel: EmployeeModel?) {
        itemView.transitionName = itemView.transitionName ?: NAME_GENERAL_TRANSITION
        val extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        val action = EmployeeFragmentDirections.actionMainFragmentToDetailEmployeeFragment(
            employeeModel,
            itemView.transitionName
        )

        navController?.navigate(action, extras)
    }

}