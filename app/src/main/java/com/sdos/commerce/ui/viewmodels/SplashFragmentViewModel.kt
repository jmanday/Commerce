package com.sdos.commerce.ui.viewmodels


import android.content.Context
import com.sdos.commerce.data.room.RoomController
import com.sdos.commerce.util.ExecutorViewModel

class SplashFragmentViewModel: ExecutorViewModel() {

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