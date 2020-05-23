package com.jmanday.commerce.ui.activities

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jmanday.commerce.CommerceApp
import com.jmanday.commerce.R
import com.jmanday.commerce.di.ModuleInjector
import com.jmanday.commerce.listeners.FragmentListener
import com.manday.coredata.navigation.Navigate
import com.manday.loginuser.injector.LoginUserViewInjector
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
        Navigate.navController = navController
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
                R.id.blankFragment -> {
                    navController.navigate(R.id.action_blankFragment_self)
                }
                R.id.fruitFragment -> {
                    navController.navigate(R.id.action_fruitFragment_self)
                }
            }

            true
        }

    }

    override fun onNavigationUp() {
        navController.navigateUp()
    }

    override fun onDatabasePopulated() {
        navController.navigate(
            R.id.nav_graph_management, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.splashFragment, true)
                .build())

        loginUserInjector.provideLoginDialogView().show(supportFragmentManager, "")
        bottomNavigationView.visibility = VISIBLE
    }

    override fun showNavigationBottomView() {
        bottomNavigationView.visibility = VISIBLE
    }

    override fun hideNavigationBottomView() {
        bottomNavigationView.visibility = GONE
    }
}
