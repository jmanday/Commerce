package com.manday.coredata.navigation

import android.view.View
import androidx.navigation.NavController

interface Navigate<T> {

    fun navigate(itemView: View? = null, t: T? = null)

    companion object {
        var navController: NavController? = null
    }
}