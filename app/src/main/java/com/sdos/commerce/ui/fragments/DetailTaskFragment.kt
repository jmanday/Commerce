package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdos.commerce.databinding.FragmentDetailTaskBinding
import com.sdos.commerce.entities.Task
import com.sdos.commerce.R
import com.sdos.commerce.ui.viewmodels.DetailTaskViewModel
import kotlinx.android.synthetic.main.fragment_detail_task.*


class DetailTaskFragment : BaseFragment() {

    private var task = Task()
    private lateinit var binding: FragmentDetailTaskBinding
    private lateinit var viewModel: DetailTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTaskBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.task = task
    }

    override fun retrieveArguments() {
        arguments?.let {
            it.get(ARGUMENT_EXTRA_TASK)?.let {emp ->
                task = emp as Task
            }
        }
    }

    override fun initializeViewModel() {
        viewModel = getViewModel()
        viewModel.setListener(this)
    }

    override fun initialize() {
        val stateAdapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.task_state))
        val durationAdapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.duration))
        var employeesAdapter: ArrayAdapter<String>
        var typeTaskAdapter: ArrayAdapter<String>

        viewModel.getTypeTasks().observe(this, Observer {
            it?.let {
                typeTaskAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, it.map { it.name })
                typeTaskAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                spn_type.adapter = typeTaskAdapter
            }
        })

        viewModel.getListEmployees().observe(this, Observer {
            it?.let {
                spn_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        employeesAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
                            viewModel.getEmployeeBySkil(viewModel.getSkillFromTask(position)).map { it.name })
                        employeesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                        spn_selected_employee.adapter = employeesAdapter
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
            }
        })

        stateAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        durationAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        spn_state.adapter = stateAdapter
        spn_duration.adapter = durationAdapter
        setListeners()
    }

    private fun setListeners() {
        btnDone.setOnClickListener {
            task.duration = resources.getStringArray(R.array.duration).get(spn_duration.selectedItemPosition).split(" ").first().toDouble()
            task.state = spn_state.selectedItemPosition
            task.type = viewModel.getTypeTask(spn_type.selectedItemPosition).id ?: 0
            task.idEmployee = viewModel.getEmployeeBySkil(viewModel.getSkillFromTask(task.type))
                .get(spn_selected_employee.selectedItemPosition).id
            viewModel.addTask(task)
        }
    }
}
