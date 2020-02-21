package com.sdos.login.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.sdos.login.R
import com.sdos.login.ui.viewmodels.LoginViewModel


class LoginDialogView: DialogFragment() {

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(LoginViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_view_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false

    }

    companion object {
        fun newInstance() = LoginDialogView()
    }
}