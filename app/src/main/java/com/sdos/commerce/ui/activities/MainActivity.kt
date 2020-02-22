package com.sdos.commerce.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdos.commerce.R
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.ui.views.LoginDialogView
import com.sdos.commerce.util.Converter
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private var db: CommerceDatabase? = null
    private var employeeDao: EmployeeDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginDialogView.newInstance().show(supportFragmentManager, "")
    }

}
