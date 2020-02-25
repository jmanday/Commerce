package com.sdos.commerce.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker

import com.sdos.commerce.R
import com.sdos.commerce.ui.views.DateDialogView
import com.sdos.commerce.ui.views.DateDialogView.Companion.TAG_DATE_DIALOG
import kotlinx.android.synthetic.main.fragment_detail_employee.*

class DetailEmployeeFragment : Fragment(R.layout.fragment_detail_employee) {

    private var date: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
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
