package com.sdos.commerce.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewmodels.LoginDialogViewModel
import kotlinx.android.synthetic.main.login_custom_view.*


class LoginDialogView: DialogFragment() {

    private lateinit var listener: LoginDialogListener
    private val loginDialogViewModel: LoginDialogViewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(LoginDialogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_custom_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false
        initializeListeners()
    }

    private fun initializeListeners() {
        btnDone.setOnClickListener {
            loginDialogViewModel.loginUser(ed_user.text.toString(), ed_pass.text.toString()).observe(this, Observer {
                if (it == null) {
                    message.visibility = VISIBLE
                } else {
                    listener.userLoggedIn()
                    this.dismiss()
                }
            })
        }
    }

    fun setListener(listener: LoginDialogListener): LoginDialogView {
        this.listener = listener
        return this
    }

    companion object {
        fun newInstance() = LoginDialogView()
    }

    interface LoginDialogListener {
        fun userLoggedIn()
    }
}