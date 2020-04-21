package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coredata.TypeError
import com.manday.coredata.utils.showMessageError
import com.manday.coreui.fragment.BaseFragment
import com.manday.coreui.ui.DateDialogView
import com.manday.coreui.ui.DateDialogView.Companion.TAG_DATE_DIALOG
import com.manday.management.R
import com.manday.management.data.entities.SkillEntity
import com.manday.management.databinding.FragmentEmployeeDetailBinding

import com.manday.management.domain.EmployeeModel
import com.manday.management.ui.viewmodels.EmployeeDetailViewModel
import kotlinx.android.synthetic.main.fragment_employee_detail.*
import kotlinx.android.synthetic.main.fragment_employee_detail.view.*
import kotlinx.android.synthetic.main.fragment_employee_detail.view.toolbar
import org.koin.java.KoinJavaComponent.inject

class EmployeeDetailFragment : BaseFragment() {

    private val viewModel: EmployeeDetailViewModel by inject(EmployeeDetailViewModel::class.java)
    private lateinit var binding: FragmentEmployeeDetailBinding
    private lateinit var mapInputText: Map<EmployeeDetailViewModel.ErrorField, TextInputLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation = MaterialContainerTransform(requireContext()).apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            duration = 500
        }
        sharedElementEnterTransition = transformation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeDetailBinding.inflate(inflater)
            .apply {
                val employeeModel = arguments?.get(ARGUMENT_EXTRA_EMPLOYEE) as EmployeeModel
                viewModel.initialize(employeeModel)
                employee = employeeModel
                root.transitionName = employeeModel.name
            }

        listener.hideNavigationBottomView()

        return binding.root
    }

    override fun initialize() {
        prepareListeners()
        populateMap()

        viewModel.skills().observe(this, Observer {
            it?.let {
                val adapter = ArrayAdapter(requireContext(), R.layout.list_item, it.map { it.name })
                (binding.inputSkill.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            }
        })

        binding.autocompleteType.setText(viewModel.employeeModel?.typeEmployeeDescription)

        Glide.with(binding.root)
            .load(viewModel.employeeModel?.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(binding.root.imgMain)

        Glide.with(binding.root)
            .load(viewModel.employeeModel?.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(binding.root.imgProfile)
    }

    private fun populateMap() {
        mapInputText = mapOf(
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_NAME to inputName,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_SURNAME to inputSurname,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_EMAIL to inputPhone,
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
    }

    private fun buttonSaveClicked() {
        binding.progressBar.visibility = VISIBLE
        binding.root.isEnabled = false
        viewModel.buttonSaveClicked().observe(this, Observer {
            binding.progressBar.visibility = GONE
            when (it.typeError) {
                TypeError.SUCCESS -> {
                    it.message?.let {
                        showMessage(it, true)
                    }
                }
                TypeError.ERROR, TypeError.NOT_FOUND, TypeError.DATASOURCE -> {
                    it.resp?.let { response ->
                        response.forEach { errorField ->
                            it.message?.let { message ->
                                mapInputText[errorField]?.showMessageError(message)
                            }
                        }
                    }
                }
            }
        })
    }
}
