package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewmodels.SplashFragmentViewModel
import org.koin.java.KoinJavaComponent.inject

class SplashFragment : BaseFragment() {

    private val viewModel: SplashFragmentViewModel by inject(SplashFragmentViewModel::class.java)

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
