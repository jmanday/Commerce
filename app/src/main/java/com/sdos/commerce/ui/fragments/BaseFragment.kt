package com.sdos.commerce.ui.fragments


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sdos.commerce.listeners.FragmentListener
import com.sdos.commerce.listeners.ViewModelListener


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
        getViewModel()
        initialize()
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        listener.onNavigationUp()
    }

    protected fun onItemClicked(actionId: Int, bundle: Bundle) {
        listener.onNavigationPush(actionId, bundle)
    }

    protected fun onButtonAddClicked(actionId: Int) {
        listener.onNavigationPush(actionId, null)
    }

    protected fun onDatabasePopulated() {
        listener.onDatabasePopulated()
    }

    open protected fun retrieveArguments() {}

    abstract fun initialize()

    abstract fun getViewModel()

    companion object {
        const val ARGUMENT_EXTRA_EMPLOYEE = "ARGUMENT_EXTRA_EMPLOYEE"
        const val ARGUMENT_EXTRA_TASK = "ARGUMENT_EXTRA_TASK"
        const val ARGUMENT_EXTRA_LIST_FRUITS = "ARGUMENT_EXTRA_LIST_FRUITS"
    }
}
