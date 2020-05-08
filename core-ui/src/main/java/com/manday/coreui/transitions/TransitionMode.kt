package com.manday.coredata.transitions

import android.content.Context
import android.transition.Transition
import com.manday.coreui.transitions.TransitionData

interface TransitionMode {

    fun make(context: Context, data: TransitionData): Transition

}