package com.manday.management.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SpinnerAdapter(
    context: Context,
    resourceId: Int,
    listItems: List<String>
) : ArrayAdapter<String>(context, resourceId, listItems) {

    private var errorMessage: String? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (errorMessage != null && position == 0) {
            val initialView = super.getView(position, convertView, parent)
            (initialView as TextView).apply {
                setError("")
                setTextColor(Color.RED)
                setText(errorMessage)
            }
            return initialView
        }
        return super.getView(position, convertView, parent)
    }

    fun setError(message: String) {
        errorMessage = message
    }
}