package com.manday.management.navigation

import com.manday.coredata.navigation.AutoNavigate
import com.manday.coredata.navigation.Navigate.Companion.navController

class NavigateToBack : AutoNavigate<Any> {

    override fun navigate(t: Any?) {
        navController?.navigateUp()
    }
}