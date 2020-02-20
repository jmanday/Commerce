package com.sdos.commerce.ui.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sdos.commerce.R

interface SplashFragmentListener {
    fun onSplahLoaded()
}

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        
    }

    companion object {
        const val DELAY = 5
    }
}
