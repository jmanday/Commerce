package com.manday.coreui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jmanday.commerce.listeners.FragmentListener
import com.jmanday.commerce.listeners.ViewModelListener


abstract class BaseFragment: Fragment(), ViewModelListener {

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
    }

    override fun showMessage(message: String, withNavigation: Boolean) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        if (withNavigation)
            listener.onNavigationUp()
    }

    protected fun onItemClicked(actionId: Int, bundle: Bundle, view: View) {
        listener.onNavigationPush(actionId, bundle, view)
    }

    protected fun onButtonAddClicked(actionId: Int) {
        //listener.onNavigationPush(actionId, null)
    }

    protected fun onDatabasePopulated() {
        listener.onDatabasePopulated()
    }

    open protected fun retrieveArguments() {}

    abstract fun initialize()

    companion object {
        const val ARGUMENT_EXTRA_TASK = "ARGUMENT_EXTRA_TASK"
        const val ARGUMENT_EXTRA_LIST_FRUITS = "ARGUMENT_EXTRA_LIST_FRUITS"
    }
}
