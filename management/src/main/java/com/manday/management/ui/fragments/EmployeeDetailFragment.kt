package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.transition.MaterialContainerTransform.FADE_MODE_CROSS
import com.manday.coredata.transitions.ContainerTransformFade
import com.manday.coredata.transitions.TransitionMode
import com.manday.coredata.utils.TypeResponse
import com.manday.coredata.utils.showMessageError
import com.manday.coreui.fragment.BaseFragment
import com.manday.coreui.transitions.ContainerTransformData
import com.manday.coreui.transitions.TransitionData
import com.manday.management.Constants.ARGUMENT_EXTRA_EMPLOYEE
import com.manday.management.Constants.ARGUMENT_EXTRA_NAME_TRANSITION
import com.manday.management.R
import com.manday.management.databinding.FragmentEmployeeDetailBinding
import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.viewmodels.EmployeeDetailViewModel
import kotlinx.android.synthetic.main.fragment_employee_detail.*
import kotlinx.android.synthetic.main.fragment_employee_detail.view.*
import org.koin.java.KoinJavaComponent.inject

class EmployeeDetailFragment : BaseFragment() {

    private val viewModel: EmployeeDetailViewModel by lazy {
        ViewModelProvider(this).get(EmployeeDetailViewModel::class.java)
    }
    private lateinit var binding: FragmentEmployeeDetailBinding
    private var employeeModel = EmployeeModel()
    private lateinit var mapInputText: Map<EmployeeDetailViewModel.ErrorField, TextInputLayout>
    private val transition: TransitionMode by inject(ContainerTransformFade::class.java)
    private val data: TransitionData = ContainerTransformData(FADE_MODE_CROSS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = transition.make(requireContext(), data)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeDetailBinding.inflate(inflater)
            .apply {
                arguments?.let { it ->
                    it.get(ARGUMENT_EXTRA_EMPLOYEE)?.let { argEmployee ->
                        employeeModel = argEmployee as EmployeeModel
                    }
                    it.getString(ARGUMENT_EXTRA_NAME_TRANSITION)?.let { nameTransition ->
                        root.transitionName = nameTransition
                    }
                }
                employee = employeeModel
            }

        viewModel.initialize(employeeModel)
        listener.hideNavigationBottomView()

        return binding.root
    }

    override fun initialize() {
        prepareListeners()
        populateMap()

        viewModel.skills.observe(this, Observer {
            it?.let {
                val adapter = ArrayAdapter(requireContext(), R.layout.list_item, it.map { it.name })
                (binding.inputSkill.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            }
        })

        Glide.with(binding.root)
            .load(viewModel.employeeModel.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(binding.root.imgMain)

        Glide.with(binding.root)
            .load(viewModel.employeeModel.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(binding.root.imgProfile)
    }

    private fun populateMap() {
        mapInputText = mapOf(
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_NAME to inputName,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_SURNAME to inputSurname,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_PHONE to inputPhone,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_EMAIL to inputMail,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_COUNTRY to inputCountry,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_SKILL to inputSkill
        )
    }

    private fun prepareListeners() {
        toolbar.setNavigationOnClickListener {
            listener.onNavigationUp()
        }

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.btnSave -> {
                    buttonSaveClicked()
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.inputSkill.autocompleteType.setOnItemClickListener { parent, view, position, id ->
            employeeModel.skillEmployeeDescription = parent.adapter.getItem(position) as String
            employeeModel.skillEmployee = position
        }
    }

    private fun buttonSaveClicked() {
        binding.progressBar.visibility = VISIBLE
        binding.clInfo.isEnabled = false
        viewModel.fields().observe(this, Observer {
            binding.progressBar.visibility = GONE
            binding.clInfo.isEnabled = true

            if (it.isEmpty()) {
                viewModel.buttonSaveClicked().observe(this, Observer {
                    if (it != null) {
                        when (it) {
                            TypeResponse.INSERT_OK -> {
                                showMessage(getString(R.string.text_saved), true)
                            }
                        }
                    }
                })
            } else {
                it.forEach { errorField ->
                    mapInputText[errorField]?.showMessageError(getString(R.string.text_empty_fields))
                }
            }
        })
    }
}
