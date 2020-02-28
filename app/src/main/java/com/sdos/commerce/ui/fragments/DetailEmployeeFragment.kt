package com.sdos.commerce.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentDetailEmployeeBinding
import com.sdos.commerce.ui.viewmodels.DetailEmployeeViewModel
import com.sdos.commerce.ui.views.DateDialogView
import com.sdos.commerce.ui.views.DateDialogView.Companion.TAG_DATE_DIALOG
import kotlinx.android.synthetic.main.fragment_detail_employee.*

class DetailEmployeeFragment : Fragment(){

    private var date: String? = null
    private lateinit var viewModel: DetailEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentDetailEmployeeBinding.inflate(inflater)
            .apply {
                test = false
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailEmployeeViewModel::class.java)
        viewModel.init()
        initialize()
    }

    private fun initialize() {
        viewModel.getListSkills().observe(this, Observer {
            context?.let {context ->
                val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, it.map { it.name })
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spn_rol.adapter = adapter
            }
        })

        ed_date.setOnClickListener {
            fragmentManager?.let { fm ->
                DateDialogView.newInstance()
                    .apply {
                        setListener {
                            date = it
                        }
                    }
                    .show(fm, TAG_DATE_DIALOG) }
        }
    }
}
