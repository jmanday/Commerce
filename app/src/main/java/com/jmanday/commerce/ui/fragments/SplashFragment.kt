package com.jmanday.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmanday.commerce.R
import com.jmanday.commerce.ui.viewmodels.SplashViewModel
import com.manday.coreui.fragment.BaseFragment
import org.koin.java.KoinJavaComponent.inject

class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by inject(SplashViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun initialize() {
        viewModel.initialize(requireContext()) {
            onDatabasePopulated()
        }
    }
}
