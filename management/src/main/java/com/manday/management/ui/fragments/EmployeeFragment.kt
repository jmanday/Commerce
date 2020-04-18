package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.transition.Hold
import com.manday.coredata.TypeError
import com.manday.coreui.fragment.BaseFragment
import com.manday.employee.ui.adapters.EmployeeAdapter
import com.manday.management.R
import com.manday.management.databinding.FragmentEmployeeBinding
import com.manday.management.ui.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_employee.*
import kotlinx.android.synthetic.main.list_item_view.*
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

class EmployeeFragment : BaseFragment() {

    private val viewModel: EmployeeViewModel by inject(
        EmployeeViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //exitTransition = Hold()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentEmployeeBinding.inflate(inflater).root
    }

    override fun initialize() {
        //onButtonAddClicked(R.id.action_mainFragment_to_detailEmployeeFragment)
        mainRecyclerView.showShimmer()
        viewModel.getEmployees().observe(this, Observer {
            mainRecyclerView.hideShimmer()
            when (it.typeError) {
                TypeError.SUCCESS -> {
                    it.resp?.let {
                        mainRecyclerView.adapter = EmployeeAdapter(it) {employeeModel, view ->
                            listener.onNavigationPush(R.id.btnAdd,
                                Bundle().apply {
                                    putSerializable(ARGUMENT_EXTRA_EMPLOYEE, employeeModel)
                                }, view)
                        }
                    }
                }
                TypeError.NOT_FOUND, TypeError.DATASOURCE -> {
                    if (it.text.isNotEmpty())
                        showMessage(it.text, false)
                }
            }
        })

    }
}
