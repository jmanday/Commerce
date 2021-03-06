package com.manday.coredata.transitions

import android.content.Context
import android.transition.Transition
import com.manday.coreui.transitions.TransitionAttributes

interface TransitionMode {

    fun make(context: Context, transitionAttributes: TransitionAttributes): Transition

}