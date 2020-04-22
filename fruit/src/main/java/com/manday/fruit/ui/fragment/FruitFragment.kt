package com.manday.fruit.ui.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manday.coredata.TypeError
import com.manday.coreui.fragment.BaseFragment
import com.manday.fruit.databinding.FragmentFruitBinding
import com.manday.fruit.ui.adapter.FruitAdapter
import com.manday.fruit.ui.viewmodel.FruitViewModel
import kotlinx.android.synthetic.main.fragment_fruit.*
import org.koin.java.KoinJavaComponent.inject

class  FruitFragment : BaseFragment() {

    private val viewModel: FruitViewModel by inject(FruitViewModel::class.java)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val a = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = 22
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
        /*
        viewModel.getAllFruits().observe(this, Observer {response ->
            mainRecyclerView.visibility = View.VISIBLE
            //determinateBar.visibility = View.GONE

            when (response.typeError) {
                TypeError.SUCCESS -> {
                    response.resp?.let {
                        val adapter = FruitAdapter(it) { fruitModel, view ->

                        }
                        mainRecyclerView.adapter = adapter
                    }
                }
                TypeError.DATASOURCE, TypeError.NOT_FOUND -> {
                    if (response.text.isNotEmpty())
                        showMessage(response.text, false)
                }
            }
        })

         */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val a = 45
    }

    override fun onDestroy() {
        super.onDestroy()
        val a = 22
    }

    override fun onDetach() {
        super.onDetach()
        val a =44
    }

}
