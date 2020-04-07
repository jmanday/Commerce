package com.sdos.commerce.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coreui.fragment.BaseFragment
import com.sdos.commerce.R
import com.sdos.commerce.databinding.FragmentSettingBinding
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSettingBinding.inflate(inflater).root
    }

    override fun initialize() {
        tv_download.setOnClickListener {
            onItemClicked(R.id.action_settingFragment_to_fruitFragment, Bundle())
        }
    }
}
