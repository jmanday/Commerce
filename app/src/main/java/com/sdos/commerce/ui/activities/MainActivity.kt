package com.sdos.commerce.ui.activities

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.ui.NavigationUI
import com.manday.coreui.fragment.BaseFragment
import com.manday.loginuser.injector.LoginUserViewInjector
import com.manday.management.Constants.ARGUMENT_EXTRA_EMPLOYEE
import com.manday.management.Constants.ARGUMENT_EXTRA_NAME_TRANSITION
import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.fragments.EmployeeDetailFragment
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.R
import com.sdos.commerce.di.ModuleInjector
import com.sdos.commerce.listeners.FragmentListener
import com.sdos.commerce.util.CustomFragmentNavigator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private var loginUserInjector: LoginUserViewInjector = (CommerceApp.getInstance() as ModuleInjector).provideUserLoginInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        //navController.navigatorProvider.addNavigator(CustomFragmentNavigator(this, nav_host_fragment.childFragmentManager, R.id.nav_host_fragment))
        bottomNavigationView.visibility = GONE
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId

            if (menuItem.isChecked)
                return@setOnNavigationItemSelectedListener false

            when (id) {
                R.id.employeeFragment -> {
                    navController.navigate(R.id.action_employeeFragment_self)
                }
                R.id.taskFragment -> {
                    navController.navigate(R.id.action_taskFragment_self)
                }
                R.id.fruitFragment -> {
                    navController.navigate(R.id.action_fruitFragment_self)
                }
            }

            true
        }

    }

    override fun onNavigationPush(actionId: Int, bundle: Bundle?, itemView: View) {
        var extras: FragmentNavigator.Extras? = null
        bundle?.let {
            it.getString(ARGUMENT_EXTRA_NAME_TRANSITION)?.let { nameTransition ->
                extras = FragmentNavigatorExtras(itemView to nameTransition)
            }
        }

        navController.navigate(R.id.action_mainFragment_to_detailEmployeeFragment, bundle, null, extras)
    }

    override fun onNavigationUp() {
        navController.navigateUp()
        bottomNavigationView.visibility = VISIBLE
    }

    override fun onDatabasePopulated() {
        navController.navigate(R.id.employeeFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.splashFragment, true)
                .build())

        loginUserInjector.provideLoginDialogView().show(supportFragmentManager, "")
        bottomNavigationView.visibility = VISIBLE
    }

    override fun hideNavigationBottomView() {
        bottomNavigationView.visibility = GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        bottomNavigationView.visibility = VISIBLE
    }
}
