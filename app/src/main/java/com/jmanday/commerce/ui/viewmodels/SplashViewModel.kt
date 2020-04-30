package com.jmanday.commerce.ui.viewmodels

import android.content.Context
import com.manday.coredata.ExecutorViewModel
import com.manday.fruit.controllers.FruitRoomController
import com.manday.management.data.controllers.RoomController

class SplashViewModel: ExecutorViewModel() {

    fun initialize(context: Context, dbInitialized: () -> Unit) {
        if (FruitRoomController.getInstance() == null)
            FruitRoomController.initialize(context)

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