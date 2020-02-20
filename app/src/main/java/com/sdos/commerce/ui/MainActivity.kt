package com.sdos.commerce.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.sdos.commerce.R
import com.sdos.commerce.ui.fragments.SplashFragmentListener

class MainActivity : AppCompatActivity(), SplashFragmentListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSplahLoaded() {
        navController.navigate(R.id.loginFragment)
    }
}
