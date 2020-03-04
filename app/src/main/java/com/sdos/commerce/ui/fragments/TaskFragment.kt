package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentMainBinding
import com.sdos.commerce.entities.Task
import com.sdos.commerce.ui.adapters.TaskAdapter
import com.sdos.commerce.ui.viewmodels.TaskFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.text_head

class TaskFragment : BaseFragment() {

    private lateinit var viewModel: TaskFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMainBinding.inflate(inflater).root
    }

    override fun getViewModel() {
        viewModel = ViewModelProviders.of(this).get(TaskFragmentViewModel::class.java)
        viewModel.initialize()
    }

    override fun initialize() {
        configureSpinner()
        text_head.text = "Tareas"
        ll_filter.visibility = VISIBLE
        main_recycler_view.showShimmer()
        viewModel.getTasks().observe(this, Observer {
            if (it != null) {
                updateRecyclerView(it)
                main_recycler_view.hideShimmer()
            }
        })
        btnAdd.setOnClickListener {
            onButtonAddClicked(R.id.action_taskFragment_to_detailTaskFragment)
        }
    }

    private fun configureSpinner() {
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.filter_by))
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spn_filter.adapter = adapter
        spn_filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val taskList = when (position) {
                    0 -> { viewModel.getAllTasks() }
                    1 -> { viewModel.getPendingTasks() }
                    2 -> { viewModel.getCompletedTasks() }
                    else -> { viewModel.getAllTasks() }
                }
                updateRecyclerView(taskList)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun updateRecyclerView(taskList: List<Task>?) {
        taskList?.let {
            main_recycler_view.adapter = TaskAdapter(it) {
                onItemClicked(R.id.action_taskFragment_to_detailTaskFragment, Bundle().apply {
                    putSerializable(ARGUMENT_EXTRA_TASK, it)
                })
            }
        }
    }
}
