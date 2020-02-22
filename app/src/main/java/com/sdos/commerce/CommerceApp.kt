package com.sdos.commerce

import android.app.Application
import com.sdos.commerce.data.room.CommerceDatabase

class CommerceApp: Application() {

    override fun onCreate() {
        super.onCreate()
        CommerceDatabase.getInstance(applicationContext)
    }

    companion object {
        private var instance: CommerceApp? = null

        fun getInstance(): CommerceApp? {
            if (instance == null) {
                synchronized(CommerceApp::class) {
                    instance = CommerceApp()
                }
            }

            return instance
        }
    }
}