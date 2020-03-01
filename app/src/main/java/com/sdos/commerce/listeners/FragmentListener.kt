package com.sdos.commerce.listeners

import android.os.Bundle

interface FragmentListener {

    fun onNavigationPush(actionId: Int, bundle: Bundle?)

    fun onNavigationUp()
}