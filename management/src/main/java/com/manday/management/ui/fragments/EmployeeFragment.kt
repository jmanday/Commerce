package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manday.coreui.fragment.BaseFragment
import com.manday.employee.R
import com.manday.employee.databinding.FragmentEmployeeBinding
import com.manday.employee.ui.adapters.EmployeeAdapter
import com.manday.employee.ui.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_employee.*
import org.koin.java.KoinJavaComponent.inject

class EmployeeFragment : BaseFragment() {

    private val viewModel: EmployeeViewModel by inject(
        EmployeeViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentEmployeeBinding.inflate(inflater).root
    }

    override fun initialize() {
        mainRecyclerView.showShimmer()
        text_head.text = "Empleados"
        btnAdd.setOnClickListener {
            //onButtonAddClicked(R.id.action_mainFragment_to_detailEmployeeFragment)
        }

        viewModel.getEmployees().observe(this, Observer {response ->
            response.extra?.let {
                mainRecyclerView.adapter =
                    EmployeeAdapter(it) {
                        /*
                        onItemClicked(
                            R.id.action_mainFragment_to_detailEmployeeFragment,
                            Bundle().apply {
                                putSerializable(ARGUMENT_EXTRA_EMPLOYEE, it)
                            })

                         */
                    }
            }

            if (response.text.isNotEmpty())
                showMessage(response.text, false)
        })

    }
}