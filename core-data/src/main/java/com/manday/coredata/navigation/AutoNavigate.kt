package com.manday.coredata.navigation

interface AutoNavigate<T> : Navigate {

    fun navigate(t: T? = null)
}