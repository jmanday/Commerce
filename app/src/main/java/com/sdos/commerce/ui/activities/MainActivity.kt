package com.sdos.commerce.ui.activities

import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdos.commerce.CommerceApp
import com.sdos.commerce.R
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.domain.injector.DomainInjector
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.listeners.FragmentListener
import com.sdos.commerce.ui.fragments.EmployeeFragment
import com.sdos.commerce.ui.views.LoginDialogView
import com.sdos.commerce.util.Converter
import com.sdos.commerce.util.ExecutorViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity(), FragmentListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

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
        bottom_navigation.visibility = VISIBLE
        LoginDialogView.newInstance()
            .show(supportFragmentManager, "")
    }
}
