package com.sdos.commerce.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdos.commerce.R
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Executors.newSingleThreadScheduledExecutor()
            .schedule({
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finishAffinity()
            },
                DELAY, TimeUnit.SECONDS)
    }

    companion object {
        const val DELAY = 5L
    }
}
