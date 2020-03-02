package com.sdos.commerce.ui.viewmodels


import android.content.Context
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.util.ExecutorViewModel

class SplashViewModel: ExecutorViewModel() {

    fun initialize(context: Context, dbInitialized: () -> Unit) {
        if (CommerceDatabase.getInstance() == null) {
            doInBackgroundAndWait {
                CommerceDatabase.initialize(context) {
                    waitAndRunInForeground{
                        dbInitialized.invoke()
                    }
                }
            }
        }
        else {
            waitAndRunInForeground{
                dbInitialized.invoke()
            }
        }
    }

}