package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentSettingBinding
import com.sdos.commerce.entities.Fruit
import com.sdos.commerce.ui.viewmodels.SettingsViewModel
import kotlinx.android.synthetic.main.fragment_setting.*
import java.io.Serializable

class SettingFragment : BaseFragment() {

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSettingBinding.inflate(inflater).root
    }

    override fun getViewModel() {
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
    }

    override fun initialize() {
        tv_download.setOnClickListener {
            viewModel.getFruits("Fruit", "Peaches")
        }
        viewModel.fruits().observe(this, Observer {
            onItemClicked(R.id.action_settingFragment_to_fruitFragment, Bundle().apply {
                putSerializable(ARGUMENT_EXTRA_LIST_FRUITS, it as Serializable)
            })
        })
    }
}
