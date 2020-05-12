package com.manday.coredata.transitions

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.material.transition.MaterialContainerTransform
import com.manday.coreui.transitions.TransitionAttributes

class ContainerTransformFit : TransitionMode {

    override fun make(context: Context, attributes: TransitionAttributes) =
        MaterialContainerTransform(context).apply {
            fitMode = attributes.mode
            duration = 800
            scrimColor = ContextCompat.getColor(context, attributes.colorScrim)
        }
}