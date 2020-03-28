package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewmodels.SplashViewModel
import com.manday.login_user.LoginDialogView

class SplashFragment : BaseFragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun initializeViewModel() {
        viewModel = getViewModel()
    }

    override fun initialize() {
        viewModel.initialize(requireContext()) {
            onDatabasePopulated()
        }
    }
}
