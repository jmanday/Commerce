package com.sdos.commerce.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sdos.commerce.R
import com.sdos.commerce.entities.Fruit
import com.sdos.commerce.ui.adapters.FruitAdapter
import kotlinx.android.synthetic.main.fragment_fruit.*
import java.util.*

class FruitFragment : BaseFragment() {

    private var list: List<Fruit>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fruit, container, false)
    }

    override fun retrieveArguments() {
        super.retrieveArguments()
        arguments?.let {
            list = it.getSerializable(ARGUMENT_EXTRA_LIST_FRUITS) as List<Fruit>
        }
    }


    override fun getViewModel() {
    }

    override fun initialize() {
        list?.let {
            val adapter = FruitAdapter(it) {

            }
            main_recycler_view.adapter = adapter
        }

        text_head.setText("Fruits")
    }

}
