package com.sdos.commerce.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sdos.commerce.R
import kotlinx.android.synthetic.main.date_dialog_custom_view.*


class DateDialogView: DialogFragment() {

    private lateinit var btnDoneListener: (String) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.date_dialog_custom_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    private fun initializeListeners() {
        btnDone.setOnClickListener {
            date_picker.apply {
                val date = String.format(DATE_DIALOG, dayOfMonth, month, year)
                btnDoneListener.invoke(date)
                this@DateDialogView.dismiss()
            }
        }
        btnCancel.setOnClickListener {
            this.dismiss()
        }
    }

    fun setListener(btnDone: (String) -> Unit) {
        btnDoneListener = btnDone
    }

    companion object {
        const val TAG_DATE_DIALOG = "DateDialog"
        const val DATE_DIALOG = "%s/%s/%s"

        fun newInstance() = DateDialogView()
    }
}