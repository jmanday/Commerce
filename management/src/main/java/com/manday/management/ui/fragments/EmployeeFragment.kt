package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import android.transition.Fade
import com.google.android.material.transition.FadeThrough
import com.google.android.material.transition.Hold
import com.manday.coreui.fragment.BaseFragment
import com.manday.employee.ui.adapters.EmployeeAdapter
import com.manday.management.Constants.ARGUMENT_EXTRA_EMPLOYEE
import com.manday.management.Constants.ARGUMENT_EXTRA_NAME_TRANSITION
import com.manday.management.Constants.NAME_GENERAL_TRANSITION
import com.manday.management.R
import com.manday.management.databinding.FragmentEmployeeBinding
import com.manday.management.ui.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_employee.*
import org.koin.java.KoinJavaComponent.inject

class EmployeeFragment : BaseFragment() {

    private val viewModel: EmployeeViewModel by inject(
        EmployeeViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = FadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentEmployeeBinding.inflate(inflater).root
    }

    override fun initialize() {
        btnAdd.setOnClickListener {
            it.transitionName = NAME_GENERAL_TRANSITION
            listener.onNavigationPush(R.id.btnAdd,
                Bundle().apply {
                    putString(ARGUMENT_EXTRA_NAME_TRANSITION, NAME_GENERAL_TRANSITION)
                }, it)
        }
        employeeRecyclerView.showShimmer()
        viewModel.employees.observe(this, Observer { employees ->
            employeeRecyclerView.hideShimmer()
            if (employees != null) {
                employeeRecyclerView.adapter = EmployeeAdapter(employees) {employeeModel, view ->
                    listener.onNavigationPush(R.id.btnAdd,
                        Bundle().apply {
                            putSerializable(ARGUMENT_EXTRA_EMPLOYEE, employeeModel)
                            putString(ARGUMENT_EXTRA_NAME_TRANSITION, employeeModel.name)
                        }, view)
                }
            }
            else {
                showMessage(getString(R.string.error_get_datas), false)
            }
        })
    }
}
