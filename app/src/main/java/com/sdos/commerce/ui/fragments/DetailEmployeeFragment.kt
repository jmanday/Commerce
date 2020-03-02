package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputLayout
import com.sdos.commerce.databinding.FragmentDetailEmployeeBinding
import com.sdos.commerce.entities.Employee
import com.sdos.commerce.ui.viewmodels.DetailEmployeeViewModel
import com.sdos.commerce.ui.views.DateDialogView
import com.sdos.commerce.ui.views.DateDialogView.Companion.TAG_DATE_DIALOG
import com.sdos.commerce.util.showMessageError
import kotlinx.android.synthetic.main.fragment_detail_employee.*

class DetailEmployeeFragment : BaseFragment(), DetailEmployeeViewModel.DetailEmployeView {

    private lateinit var viewModel: DetailEmployeeViewModel
    private var employee = Employee()
    private lateinit var binding: FragmentDetailEmployeeBinding
    private lateinit var mapInputText: Map<ErrorField, TextInputLayout>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailEmployeeBinding.inflate(inflater)
            .apply {
                employee = null
            }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.employee = employee
        viewModel = ViewModelProviders.of(this).get(DetailEmployeeViewModel::class.java)
        viewModel.init(this)
        initialize()
    }

    private fun initialize() {
        prepareListeners()
        populateMap()
        viewModel.getListSkills().observe(this, Observer {
            context?.let {context ->
                val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, it.map { it.name })
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spn_rol.adapter = adapter
                spn_rol.setSelection(employee.skill)
            }
        })
    }

    override fun retrieveArguments() {
        arguments?.let {
            it.get(ARGUMENT_EXTRA_EMPLOYEE)?.let {emp ->
                employee = emp as Employee
            }
        }
    }

    private fun populateMap() {
        mapInputText = mapOf(
            ErrorField.ERROR_FIELD_NAME to input_name,
            ErrorField.ERROR_FIELD_SURNAME to input_surname,
            ErrorField.ERROR_FIELD_EMAIL to input_email,
            ErrorField.ERROR_FIELD_PHONE to input_phone,
            ErrorField.ERROR_FIELD_DATE to input_date,
            ErrorField.ERROR_FIELD_PASS to input_pass
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
                employee.skill = position
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
            viewModel.onButtonAddClicked(employee)
        }
    }

    override fun showError(errorFieldList: List<ErrorField>) {
        errorFieldList.forEach {
            mapInputText[it]?.showMessageError("Campo incorrecto")
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        onBackNavigation()
    }

    enum class ErrorField {
        ERROR_FIELD_NAME, ERROR_FIELD_SURNAME, ERROR_FIELD_EMAIL, ERROR_FIELD_PHONE, ERROR_FIELD_DATE, ERROR_FIELD_PASS
    }
}
