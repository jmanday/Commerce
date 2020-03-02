package com.sdos.commerce.ui.viewmodels


import android.content.Context
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.util.ExecutorViewModel

class SplashViewModel: ExecutorViewModel() {

    fun initialize(context: Context, dbCreated: () -> Unit) {
        doInBackgroundAndWait({
            CommerceDatabase.initialize(context) {
                waitlAndRunInForeground({
                    dbCreated.invoke()
                })
            }
        })
    }

}