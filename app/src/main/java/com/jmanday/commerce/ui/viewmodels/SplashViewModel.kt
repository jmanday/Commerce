package com.jmanday.commerce.ui.viewmodels

import android.content.Context
import com.manday.coredata.ExecutorViewModel
import com.manday.management.data.controllers.RoomController

class SplashViewModel: ExecutorViewModel() {

    fun initialize(context: Context, dbInitialized: () -> Unit) {
        if (RoomController.getInstance() == null) {
            doInBackgroundAndWait {
                RoomController.initialize(context) {
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