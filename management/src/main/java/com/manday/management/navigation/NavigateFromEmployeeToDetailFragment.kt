package com.manday.management.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.manday.coredata.navigation.Navigate
import com.manday.coredata.navigation.Navigate.Companion.navController
import com.manday.management.Constants
import com.manday.management.Constants.ARGUMENT_EXTRA_NAME_TRANSITION
import com.manday.management.Constants.NAME_GENERAL_TRANSITION
import com.manday.management.R
import com.manday.management.domain.EmployeeModel

open class NavigateFromEmployeeToDetailFragment : Navigate<EmployeeModel> {


    open val actionId = R.id.action_mainFragment_to_detailEmployeeFragment


    override fun navigate(itemView: View?, t: EmployeeModel?) {
        var localTransitionName = NAME_GENERAL_TRANSITION
        var extras: FragmentNavigator.Extras? = null

        val bundle = Bundle().apply {
            t?.let {
                putSerializable(Constants.ARGUMENT_EXTRA_EMPLOYEE, it)
                localTransitionName = it.name
            }

            itemView?.let {
                it.transitionName = localTransitionName
                putString(ARGUMENT_EXTRA_NAME_TRANSITION, it.transitionName)
                extras = FragmentNavigatorExtras(it to it.transitionName)
            }

        }

        navController?.navigate(actionId, bundle, null, extras)
    }

}