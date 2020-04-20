package com.manday.management.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coreui.fragment.BaseFragment
import com.manday.coreui.ui.DateDialogView
import com.manday.coreui.ui.DateDialogView.Companion.TAG_DATE_DIALOG
import com.manday.management.R
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
        toolbar.setNavigationOnClickListener {
            listener.onNavigationUp()
        }

        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.inputSkill.editText as? AutoCompleteTextView)?.setAdapter(adapter)

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

        //prepareListeners()
        //populateMap()
        /*
        viewModel.getListSkills()?.observe(this, Observer {
            context?.let {context ->
                val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, it.map { it.name })
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spn_rol.adapter = adapter
                spn_rol.setSelection(binding.employee?.skill ?: 0)
            }
        })
         */
    }

    /*
    private fun populateMap() {
        mapInputText = mapOf(
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_NAME to input_name,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_SURNAME to input_surname,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_EMAIL to input_email,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_PHONE to input_phone,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_DATE to input_date,
            EmployeeDetailViewModel.ErrorField.ERROR_FIELD_PASS to input_pass
        )
    }

    private fun prepareListeners() {
        spn_rol.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //binding.employee?.skill = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        ed_date.setOnClickListener { ed ->
            fragmentManager?.let { fm ->
                DateDialogView.newInstance()
                    .apply {
                        setListener {
                            (ed as EditText).setText(it)
                        }
                    }
                    .show(fm, TAG_DATE_DIALOG) }
        }

        btnDone.setOnClickListener {
            binding.employee?.let {
                val response = viewModel.onButtonAddClicked(it)
                /*
                when (response.typeResponse) {
                    TypeResponse.TEXT -> { showMessage(response.text) }
                    TypeResponse.EXTRA, TypeResponse.EXTRA_LIST -> {
                        response.extraList?.observe(this, Observer {
                            it.forEach {
                                mapInputText[it]?.showMessageError(response.text)
                            }
                        })
                    }
                }

                 */
            }
        }
    }

     */
}
