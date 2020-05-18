package com.manday.fruit.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manday.coreui.fragment.BaseFragment
import com.manday.fruit.databinding.FragmentFruitBinding
import com.manday.fruit.ui.adapter.FruitAdapter
import com.manday.fruit.ui.viewmodel.FruitViewModel
import kotlinx.android.synthetic.main.fragment_fruit.*

class  FruitFragment : BaseFragment() {

    private val viewModel: FruitViewModel by lazy {
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFruitBinding.inflate(inflater).root
    }

    override fun initialize() {
        mainRecyclerView.showShimmer()
        viewModel.fruits().observe(this, Observer { reponse ->
            mainRecyclerView.hideShimmer()
            reponse?.let {
                val adapter = FruitAdapter(it) { fruitModel, view ->

                }
                mainRecyclerView.adapter = adapter
            }
        })
    }

}
