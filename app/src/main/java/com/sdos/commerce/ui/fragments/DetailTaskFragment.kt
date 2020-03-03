package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.sdos.commerce.databinding.FragmentDetailTaskBinding
import com.sdos.commerce.entities.Task
import com.sdos.commerce.R
import kotlinx.android.synthetic.main.fragment_detail_task.*


class DetailTaskFragment : BaseFragment() {

    private var task = Task()
    private lateinit var binding: FragmentDetailTaskBinding

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

    override fun getViewModel() {

    }

    override fun initialize() {
        val stateAdapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.task_state))
        stateAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spn_state.adapter = stateAdapter

        val durationAdapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.duration))
        durationAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spn_duration.adapter = durationAdapter
    }

}
