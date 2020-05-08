package com.manday.coredata.transitions

import android.content.Context
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coreui.transitions.ContainerTransformData
import com.manday.coreui.transitions.TransitionData

class ContainerTransformFade : TransitionMode {

    override fun make(context: Context, data: TransitionData) =
        MaterialContainerTransform(context).apply {
            fadeMode = (data as ContainerTransformData).modeTransition
            duration = 500
        }
}