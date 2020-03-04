package com.sdos.commerce.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sdos.commerce.R
import kotlinx.android.synthetic.main.fragment_fruit.*

class FruitFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fruit, container, false)
    }

    override fun retrieveArguments() {
        super.retrieveArguments()
        val b = arguments
    }


    override fun getViewModel() {
    }

    override fun initialize() {
        text_head.setText("Fruits")
    }

}
