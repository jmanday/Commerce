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
import com.manday.coreui.fragment.BaseFragment
import com.manday.loginuser.injector.LoginUserViewInjector
import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.fragments.EmployeeDetailFragment
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.R
import com.sdos.commerce.di.ModuleInjector
import com.sdos.commerce.listeners.FragmentListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private var loginUserInjector: LoginUserViewInjector = (CommerceApp.getInstance() as ModuleInjector).provideUserLoginInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    private fun initialize() {
        bottomNavigation.visibility = GONE
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_employee -> {
                    if (navController.currentDestination?.id != R.id.employeeFragment)
                        navController.navigate(R.id.employeeFragment)
                    true
                }
                R.id.action_task -> {
                    if (navController.currentDestination?.id != R.id.taskFragment)
                        navController.navigate(R.id.taskFragment)
                    true
                }
                R.id.action_setting -> {
                    if (navController.currentDestination?.id != R.id.settingFragment)
                        navController.navigate(R.id.settingFragment)
                    true
                }
                else -> true
            }
        }
    }

    override fun onNavigationPush(actionId: Int, bundle: Bundle?, itemView: View) {
        val employeeModel = bundle?.get(BaseFragment.ARGUMENT_EXTRA_EMPLOYEE) as EmployeeModel
        val extras = FragmentNavigatorExtras(itemView to employeeModel.name)

        //navController.navigate(EmployeeFragmentDirections.actionMainFragmentToDetailEmployeeFragment(employeeModel), extras)
        navController.navigate(R.id.action_mainFragment_to_detailEmployeeFragment, bundle, null, extras)
    }

    override fun onNavigationUp() {
        navController.navigateUp()
    }

    override fun onDatabasePopulated() {
        navController.navigate(R.id.employeeFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.splashFragment, true)
                .build())

        loginUserInjector.provideLoginDialogView().show(supportFragmentManager, "")
        bottomNavigation.visibility = VISIBLE
    }

    override fun hideNavigationBottomView() {
        bottomNavigation.visibility = GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        bottomNavigation.visibility = VISIBLE
    }
}
