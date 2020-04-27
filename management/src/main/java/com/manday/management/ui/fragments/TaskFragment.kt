package com.manday.management.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manday.coreui.fragment.BaseFragment
import com.manday.management.R
import com.manday.management.databinding.FragmentTaskBinding
import com.manday.management.ui.adapters.TaskAdapter
import com.manday.management.ui.viewmodels.TaskViewModel
import kotlinx.android.synthetic.main.fragment_task.*
import org.koin.java.KoinJavaComponent.inject

class TaskFragment : BaseFragment() {

    private val viewModel: TaskViewModel by inject(TaskViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentTaskBinding.inflate(inflater).root
    }

    override fun initialize() {
        taskRecyclerView.showShimmer()
        viewModel.tasks.observe(this, Observer { tasks ->
            taskRecyclerView.hideShimmer()
            if (tasks != null) {
                taskRecyclerView.adapter = TaskAdapter(tasks) { taskEntity, view ->
                    /*
                    onItemClicked(R.id.bottom_to_top, Bundle().apply {
                        putSerializable(ARGUMENT_EXTRA_TASK, it)

                     */
                }
            } else {
                showMessage(getString(R.string.error_get_datas), false)
            }
        })
    }
}
