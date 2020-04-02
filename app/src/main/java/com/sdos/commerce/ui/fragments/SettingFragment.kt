package com.sdos.commerce.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentSettingBinding
import com.sdos.commerce.ui.viewmodels.SettingsViewModel
import kotlinx.android.synthetic.main.fragment_setting.*
import org.koin.java.KoinJavaComponent.inject
import java.io.Serializable

class SettingFragment : BaseFragment() {

    private val viewModel: SettingsViewModel by inject(SettingsViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSettingBinding.inflate(inflater).root
    }

    override fun initializeViewModel() {
    }

    override fun initialize() {
        tv_download.setOnClickListener {
            viewModel.getFruits("Fruit", "Peaches").observe(this, Observer {
                onItemClicked(R.id.action_settingFragment_to_fruitFragment, Bundle().apply {
                    putSerializable(ARGUMENT_EXTRA_LIST_FRUITS, it as Serializable)
                })
            })
        }
    }
}
