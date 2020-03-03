package com.sdos.commerce.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentMainBinding
import com.sdos.commerce.ui.adapters.EmployeeAdapter
import com.sdos.commerce.ui.viewmodels.EmployeeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class EmployeeFragment : BaseFragment() {

    private lateinit var viewModel: EmployeeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMainBinding.inflate(inflater).root
    }

    override fun getViewModel() {
        viewModel = ViewModelProviders.of(this).get(EmployeeFragmentViewModel::class.java)
    }

    override fun initialize() {
        text_head.text = "Empleados"
        btnAdd.setOnClickListener {
            onButtonAddClicked(R.id.action_mainFragment_to_detailEmployeeFragment)
        }
        main_recycler_view.showShimmer()

        viewModel.getEmployees().observe(this, Observer {
            if (it != null) {
                main_recycler_view.adapter = EmployeeAdapter(it) {
                    onItemClicked(R.id.action_mainFragment_to_detailEmployeeFragment, Bundle().apply {
                        putSerializable(ARGUMENT_EXTRA_EMPLOYEE, it)
                    })
                }
                main_recycler_view.hideShimmer()
            }
        })
    }
}
