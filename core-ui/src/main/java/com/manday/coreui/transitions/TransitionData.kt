package com.manday.coreui.transitions

abstract class TransitionData

data class ContainerTransformData(
    val modeTransition: Int
) : TransitionData()