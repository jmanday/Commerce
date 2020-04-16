package com.manday.management.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.manday.management.data.entities.TaskEntity
import com.manday.coreui.fragment.BaseFragment
import com.sdos.commerce.databinding.FragmentDetailTaskBinding
import com.sdos.commerce.R
import kotlinx.android.synthetic.main.fragment_detail_task.*
import org.koin.java.KoinJavaComponent.inject


class TaskDetailFragment : BaseFragment() {

    private var task = TaskEntity()
    private lateinit var binding: FragmentDetailTaskBinding
    private val viewModel: DetailTaskViewModel by inject(DetailTaskViewModel::class.java)

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
                task = emp as TaskEntity
            }
        }
    }

    override fun initialize() {
        viewModel.setListener(this)
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.task_state))
        val durationAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.duration))
        var employeesAdapter: ArrayAdapter<String>
        var typeTaskAdapter: ArrayAdapter<String>

        viewModel.getTypeTasks()?.observe(this, Observer {
            it?.let {
                typeTaskAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, it.map { it.name })
                typeTaskAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                spn_type.adapter = typeTaskAdapter
            }
        })

        /*
        viewModel.getListEmployees()?.observe(this, Observer {
            it?.let {
                spn_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        employeesAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
                            viewModel.getEmployeeBySkill(viewModel.getSkillFromTask(position)).map { it.name })
                        employeesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                        spn_selected_employee.adapter = employeesAdapter
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
            }
        })

         */

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
            task.idEmployee = viewModel.getEmployeeBySkill(viewModel.getSkillFromTask(task.type))
                .get(spn_selected_employee.selectedItemPosition).id
            viewModel.addTask(task)
        }
    }
}
