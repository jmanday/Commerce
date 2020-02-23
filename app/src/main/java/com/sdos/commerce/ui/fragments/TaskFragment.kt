package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdos.commerce.R
import com.sdos.commerce.ui.adapters.TaskAdapter
import com.sdos.commerce.ui.viewmodels.TaskFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class TaskFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewModel: TaskFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_head.text = "Tareas"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskFragmentViewModel::class.java)
        initialize()
    }

    private fun initialize() {
        main_recycler_view.showShimmer()
        viewModel.getTasks().observe(this, Observer {
            if (it != null) {
                main_recycler_view.adapter = TaskAdapter(it) {

                }
                main_recycler_view.hideShimmer()
            }
        })
    }

}
