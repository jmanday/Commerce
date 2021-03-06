package com.manday.management.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coredata.transitions.ContainerTransformFade
import com.manday.coredata.transitions.TransitionMode
import com.manday.coredata.utils.TypeResponse
import com.manday.coreui.fragment.BaseFragment
import com.manday.coreui.transitions.TransitionAttributes
import com.manday.management.R
import com.manday.management.data.entities.TypeTaskEntity
import com.manday.management.databinding.FragmentTaskDetailBinding
import com.manday.management.domain.EmployeeModel
import com.manday.management.domain.TaskModel
import com.manday.management.domain.TaskState
import com.manday.management.navigation.NavigateToBack
import com.manday.management.ui.adapters.SpinnerAdapter
import com.manday.management.ui.viewmodels.TaskDetailViewModel
import kotlinx.android.synthetic.main.fragment_task_detail.*
import org.koin.java.KoinJavaComponent.inject


class TaskDetailFragment : BaseFragment() {

    private var taskModel = TaskModel()
    private val args: TaskDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentTaskDetailBinding
    private val viewModel: TaskDetailViewModel by lazy {
        ViewModelProvider(this).get(TaskDetailViewModel::class.java)
    }
    private val navigateToBack: NavigateToBack by inject(NavigateToBack::class.java)
    private val transition: TransitionMode by inject(ContainerTransformFade::class.java)
    private val attributes: TransitionAttributes =
        TransitionAttributes(mode = MaterialContainerTransform.FADE_MODE_CROSS)
    private var employeesAvailable: List<EmployeeModel>? = null
    private var typeTasksAvailable: List<TypeTaskEntity>? = null

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
        viewModel.setTypeTask(taskModel.type)
    }

    override fun initialize() {
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.task_state))
        val durationAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.duration))
        var employeesAdapter: ArrayAdapter<String>
        var typeTaskAdapter: ArrayAdapter<String>

        viewModel.typeTasks.observe(this, Observer {
            typeTasksAvailable = it
            it?.let {
                typeTaskAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, it.map { it.name })
                typeTaskAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                spnTypeTask.adapter = typeTaskAdapter
                spnTypeTask.setSelection(it.indexOf(it.find { typeTaskEntity ->
                    typeTaskEntity.id == taskModel.type
                }))
            }
        })

        viewModel.listEmployees.observe(this, Observer {
            employeesAvailable = it
            it?.let {
                if (it.size == 0) {
                    employeesAdapter = SpinnerAdapter(
                        requireContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        listOf("")
                    )
                    (employeesAdapter as SpinnerAdapter).setError("No existen empleados para esta tarea")
                } else {
                    employeesAdapter = SpinnerAdapter(
                        requireContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        it.map { it.name })
                }

                spnSelectedEmployee.adapter = employeesAdapter
            }
        })

        stateAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        durationAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        spn_state.adapter = stateAdapter
        spn_duration.adapter = durationAdapter
        setListeners()
    }

    private fun setListeners() {
        spnTypeTask.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.setTypeTask(typeTasksAvailable?.get(position)?.id)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        })

        btnDone.setOnClickListener {
            //taskModel.duration = resources.getStringArray(R.array.duration).get(spn_duration.selectedItemPosition).split(" ").first().toDouble()
            taskModel.state = TaskState.getState(spn_state.selectedItemPosition)
            setTypeTask()
            setEmployee()

            viewModel.updateTask(taskModel).observe(this, Observer {
                if (it != null) {
                    when (it) {
                        is TypeResponse.Success -> {
                            showMessage(getString(R.string.text_saved))
                            navigateToBack.navigate()
                        }
                    }
                }
            })
        }
    }

    private fun setEmployee() {
        if (employeesAvailable != null && employeesAvailable?.size != 0) {
            taskModel.employeeId =
                employeesAvailable?.get(spnSelectedEmployee.selectedItemPosition)?.id
            taskModel.imgEmployee =
                employeesAvailable?.get(spnSelectedEmployee.selectedItemPosition)?.image ?: ""
        } else {
            taskModel.employeeId = null
            taskModel.imgEmployee = ""
        }
    }

    private fun setTypeTask() {
        if (typeTasksAvailable != null && typeTasksAvailable?.size != 0) {
            taskModel.type = typeTasksAvailable?.get(spnTypeTask.selectedItemPosition)?.id ?: 0
        } else {
            taskModel.type = 0
        }
    }
}
