package com.sdos.commerce.ui.activities

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.manday.loginuser.injector.LoginUserInjector
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.R
import com.sdos.commerce.di.ModuleInjector
import com.sdos.commerce.listeners.FragmentListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private var loginUserInjector: LoginUserInjector = (CommerceApp.getInstance() as ModuleInjector).provideUserLoginInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    private fun initialize() {
        bottom_navigation.visibility = GONE
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_employee -> {
                    if (navController.currentDestination?.id != R.id.mainFragment)
                        navController.navigate(R.id.mainFragment)
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

    override fun onNavigationPush(actionId: Int, bundle: Bundle?) {
        navController.navigate(actionId, bundle)
    }

    override fun onNavigationUp() {
        navController.navigateUp()
    }

    override fun onDatabasePopulated() {
        navController.navigate(R.id.mainFragment, null,
            NavOptions.Builder()
                .setPopUpTo(R.id.splashFragment, true)
                .build())

        loginUserInjector.provideLoginDialogView().show(supportFragmentManager, "")
        bottom_navigation.visibility = VISIBLE
    }
}
