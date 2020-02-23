package com.sdos.commerce.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.sdos.commerce.R
import com.sdos.commerce.ui.adapters.EmployeeAdapter
import com.sdos.commerce.ui.viewmodels.EmployeeFragmentViewModel
import kotlinx.android.synthetic.main.employee_fragment.*

class EmployeeFragment : Fragment() {

    private lateinit var viewModel: EmployeeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EmployeeFragmentViewModel::class.java)
        initialize()
    }

    private fun initialize() {
        employee_recycler_view.showShimmer()
        viewModel.getEmployees().observe(this, Observer {
            if (it != null) {
                employee_recycler_view.adapter = EmployeeAdapter(it) {

                }
                employee_recycler_view.hideShimmer()
            }
        })
    }

}
