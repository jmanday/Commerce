package com.jmanday.commerce.listeners

import android.os.Bundle
import android.view.View

interface FragmentListener {

    fun onNavigationPush(actionId: Int, bundle: Bundle?, view: View)

    fun onNavigationUp()

    fun onDatabasePopulated()

    fun hideNavigationBottomView()
}