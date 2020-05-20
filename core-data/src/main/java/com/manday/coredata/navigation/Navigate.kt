package com.manday.coredata.navigation

import androidx.navigation.NavController

interface Navigate {

    companion object {
        var navController: NavController? = null
    }
}