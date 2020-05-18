package com.manday.coredata.transitions

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coreui.transitions.TransitionAttributes

class ContainerTransformFade : TransitionMode {


    override fun make(context: Context, attributes: TransitionAttributes) =
        MaterialContainerTransform(context).apply {
            fadeMode = attributes.mode
            duration = attributes.duration
            scrimColor = ContextCompat.getColor(context, attributes.colorScrim)
        }
}