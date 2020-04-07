package com.manday.fruit.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.coredata.entities.FruitEntity
import com.manday.coreui.fragment.BaseFragment
import com.manday.fruit.databinding.FragmentFruitBinding
import kotlinx.android.synthetic.main.fragment_fruit.*

class FruitFragment : BaseFragment() {

    private var list: List<FruitEntity>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFruitBinding.inflate(inflater).root
    }

    override fun retrieveArguments() {
        super.retrieveArguments()
        arguments?.let {
            list = it.getSerializable(ARGUMENT_EXTRA_LIST_FRUITS) as List<FruitEntity>
        }
    }

    override fun initialize() {
        list?.let {
            val adapter = FruitAdapter(it) {

            }
            mainRecyclerView.adapter = adapter
        }

        text_head.setText("Fruits")
    }

}
