package com.sdos.commerce

import android.app.Application
import com.sdos.commerce.data.room.CommerceDatabase

class CommerceApp: Application() {

    override fun onCreate() {
        super.onCreate()
        CommerceDatabase.getInstance(applicationContext)
    }
}