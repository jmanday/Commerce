package com.manday.fruit.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manday.coredata.entities.FruitEntity
import com.manday.coreui.fragment.BaseFragment
import com.manday.fruit.databinding.FragmentFruitBinding
import com.manday.fruit.ui.adapter.FruitAdapter
import com.manday.fruit.ui.viewmodel.FruitViewModel
import kotlinx.android.synthetic.main.fragment_fruit.*
import org.koin.java.KoinJavaComponent.inject

class FruitFragment : BaseFragment() {

    private val viewModel: FruitViewModel by inject(FruitViewModel::class.java)

    private var list: List<FruitEntity>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFruitBinding.inflate(inflater).root
    }

    override fun initialize() {
        viewModel.getAllFruits().observe(this, Observer {
            it?.let {
                val adapter = FruitAdapter(it) {

                }
                mainRecyclerView.adapter = adapter
            }

            text_head.setText("Fruits")

        })
    }

}
