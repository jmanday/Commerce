package com.manday.login_user.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.manday.login_user.BaseLoginDialogView
import com.manday.login_user.R
import com.manday.login_user.viewmodels.LoginDialogViewModel
import kotlinx.android.synthetic.main.login_custom_view.*


internal class LoginDialogView: BaseLoginDialogView() {

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
            /*
            loginDialogViewModel.loginUser(et_username.text.toString(), ed_pass.text.toString()).observe(this, Observer {
                if (it == null) {
                    message.visibility = VISIBLE
                } else {
                    this.dismiss()
                }
            })

             */
        }
    }

    companion object {
        fun newInstance() = LoginDialogView()
    }

}