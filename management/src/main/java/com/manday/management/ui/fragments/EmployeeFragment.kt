package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.transition.FadeThrough
import com.manday.coredata.navigation.AutoNavigate
import com.manday.coredata.navigation.MotionNavigate
import com.manday.coreui.fragment.BaseFragment
import com.manday.employee.ui.adapters.EmployeeAdapter
import com.manday.management.R
import com.manday.management.databinding.FragmentEmployeeBinding
import com.manday.management.domain.EmployeeAdapterModel
import com.manday.management.domain.EmployeeModel
import com.manday.management.mapper.EmployeeItemAdapterMapper
import com.manday.management.navigation.NavigateFromEmployeeToDetailFragment
import com.manday.management.navigation.NavigateFromEmployeeToTaskFragment
import com.manday.management.ui.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_employee.*
import org.koin.java.KoinJavaComponent.inject

class EmployeeFragment : BaseFragment() {

    private val viewModel: EmployeeViewModel by lazy {
        ViewModelProvider(this).get(EmployeeViewModel::class.java)
    }
    private val navigateToDetailFragment: MotionNavigate<EmployeeModel> by inject(
        NavigateFromEmployeeToDetailFragment::class.java
    )
    private val navigateToTaskFragment: AutoNavigate<EmployeeAdapterModel> by inject(
        NavigateFromEmployeeToTaskFragment::class.java
    )

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
        listener.showNavigationBottomView()
        btnAdd.setOnClickListener {
            navigateToDetailFragment.navigate(it)
        }

        employeeRecyclerView.showShimmer()
        viewModel.employees.observe(this, Observer { employees ->
            employeeRecyclerView.hideShimmer()
            if (employees != null) {
                val employeesItemAdapter = EmployeeItemAdapterMapper.mapTo(employees)
                employeeRecyclerView.adapter =
                    EmployeeAdapter(employeesItemAdapter) { employee, view ->
                        when (employee) {
                            is EmployeeAdapterModel.EmployeeItemAdapterModel -> {
                                navigateToDetailFragment.navigate(
                                    view,
                                    employees.find { it.id == employee.id })
                            }
                            is EmployeeAdapterModel.HeaderItemAdapterModel -> {
                                navigateToTaskFragment.navigate()
                            }
                        }

                }
            }
            else {
                showMessage(getString(R.string.error_get_datas), false)
            }
        })
    }
}

