package com.manday.coreui.fragment

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jmanday.commerce.listeners.FragmentListener


abstract class BaseFragment : Fragment() {

    protected lateinit var listener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
    }

    protected fun showMessage(message: String, withNavigation: Boolean) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        if (withNavigation)
            listener.onNavigationUp()
    }

    protected fun onDatabasePopulated() {
        listener.onDatabasePopulated()
    }

    abstract fun initialize()

}
