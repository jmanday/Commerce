package com.sdos.commerce.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manday.coreui.fragment.BaseFragment
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentMainBinding
import com.sdos.commerce.ui.adapters.EmployeeAdapter
import com.sdos.commerce.ui.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.java.KoinJavaComponent.inject

class EmployeeFragment : BaseFragment() {

    private val viewModel: EmployeeViewModel by inject(EmployeeViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMainBinding.inflate(inflater).root
    }

    override fun initialize() {
        text_head.text = "Empleados"
        btnAdd.setOnClickListener {
            onButtonAddClicked(R.id.action_mainFragment_to_detailEmployeeFragment)
        }
        mainRecyclerView.showShimmer()

        viewModel.getEmployees()?.observe(this, Observer {
            it?.let {
                mainRecyclerView.adapter = EmployeeAdapter(it) {
                    onItemClicked(R.id.action_mainFragment_to_detailEmployeeFragment, Bundle().apply {
                        putSerializable(ARGUMENT_EXTRA_EMPLOYEE, it)
                    })
                }
                mainRecyclerView.hideShimmer()
            }
        })
    }
}
