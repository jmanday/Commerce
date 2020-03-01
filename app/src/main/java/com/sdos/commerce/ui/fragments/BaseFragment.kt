package com.sdos.commerce.ui.fragments


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sdos.commerce.listeners.FragmentListener


abstract class BaseFragment: Fragment() {

    protected lateinit var listener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveArguments()
    }

    protected fun onEmployeeClicked(actionId: Int, bundle: Bundle) {
        listener.onNavigationPush(actionId, bundle)
    }

    protected fun onBtnAddEmployeeClicked(actionId: Int) {
        listener.onNavigationPush(actionId, null)
    }

    protected fun onBackNavigation() {
        listener.onNavigationUp()
    }

    open protected fun retrieveArguments() {}

    companion object {
        const val ARGUMENT_EXTRA_EMPLOYEE = "ARGUMENT_EXTRA_EMPLOYEE"
    }
}
