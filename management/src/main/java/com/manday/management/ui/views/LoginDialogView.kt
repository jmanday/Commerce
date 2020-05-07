package com.manday.loginuser.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manday.loginuser.BaseLoginDialogView
import com.manday.loginuser.viewmodels.LoginDialogViewModel
import com.manday.management.BuildConfig
import com.manday.management.R
import kotlinx.android.synthetic.main.login_custom_view.*


internal class LoginDialogView: BaseLoginDialogView() {

    private val loginDialogViewModel: LoginDialogViewModel by lazy {
        ViewModelProvider(this).get(LoginDialogViewModel::class.java)
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
            if (BuildConfig.DEBUG) {
                this.dismiss()
            } else {
                val response =
                    loginDialogViewModel.loginUser(
                        edUsername.text.toString(),
                        edPass.text.toString()
                    )
                response.observe(this.viewLifecycleOwner, Observer {
                    if (it != null) {
                        this.dismiss()
                    } else {
                        message.visibility = VISIBLE
                    }
                })
            }
        }
    }

    companion object {
        fun newInstance() = LoginDialogView()
    }

}