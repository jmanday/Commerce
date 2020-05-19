package com.manday.management.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coredata.transitions.ContainerTransformFade
import com.manday.coredata.transitions.TransitionMode
import com.manday.coreui.fragment.BaseFragment
import com.manday.coreui.transitions.TransitionAttributes
import com.manday.management.R
import com.manday.management.databinding.FragmentTaskDetailBinding
import com.manday.management.domain.TaskModel
import com.manday.management.ui.viewmodels.TaskDetailViewModel
import kotlinx.android.synthetic.main.fragment_task_detail.*
import org.koin.java.KoinJavaComponent


class TaskDetailFragment : BaseFragment() {

    private lateinit var taskModel: TaskModel
    private val args: TaskDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentTaskDetailBinding
    private val viewModel: TaskDetailViewModel by lazy {
        ViewModelProvider(this).get(TaskDetailViewModel::class.java)
    }
    private val transition: TransitionMode by KoinJavaComponent.inject(ContainerTransformFade::class.java)
    private val attributes: TransitionAttributes =
        TransitionAttributes(mode = MaterialContainerTransform.FADE_MODE_CROSS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = transition.make(requireContext(), attributes)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskDetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.taskModel?.let {
            taskModel = it
        }

        binding.root.transitionName = args.transitionName
        binding.task = taskModel
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
        //setListeners()
    }

    /*
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

     */
}
