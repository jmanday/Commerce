package com.manday.coredata.navigation

import android.view.View

interface MotionNavigate<T> : Navigate {

    fun navigate(itemView: View, t: T? = null)
}