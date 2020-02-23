package com.sdos.commerce.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdos.commerce.R
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.ui.fragments.EmployeeFragment
import com.sdos.commerce.ui.views.LoginDialogView
import com.sdos.commerce.util.Converter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity(), LoginDialogView.LoginDialogListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginDialogView.newInstance()
            .setListener(this)
            .show(supportFragmentManager, "")
    }

    override fun userLoggedIn() {
        nav_host_fragment.childFragmentManager.primaryNavigationFragment?.let {
            (it as EmployeeFragment).userLoggedIn()
        }
    }

}
