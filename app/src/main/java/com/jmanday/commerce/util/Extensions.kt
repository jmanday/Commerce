package com.jmanday.commerce.util

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import java.util.regex.Pattern

private const val regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"
private val pattern= Pattern.compile(regex)

fun String.isDateValidate(): Boolean {
    val matcher = pattern.matcher(this)
    return (this.isNotEmpty() && matcher.matches())
}

fun TextInputLayout.showMessageError(msg: String) {
    this.error = msg
}

fun<T> MediatorLiveData<T>.addSourceNotNull(source: LiveData<T>?, observer: Observer<T>) {
    source?.let {
        this.addSource(it, observer)
    }
}

fun<T> MediatorLiveData<T>.removeSourceNotNull(source: LiveData<T>?) {
    source?.let {
        this.removeSource(it)
    }
}

fun View.incrementByTime(totalTime: Long) {
    val period = totalTime / MAX_VALUE_IN_PROPERTY
    Log.d("PERIOD", period.toString())

    val timmerTask = TimmerTask ({
        if (this.alpha.toInt() <= MAX_VALUE_IN_PROPERTY) {
            this.alpha += this.alpha.plus(10)
            Log.d("ALPHA1", this.alpha.toString())
            false
        }
        else {
            Log.d("ALPHA2", this.alpha.toString())
            true
        }
    }, { timmerTask ->
        timmerTask.cancel()
        Log.d("ALPHA3", "Cancelado")
    })
    Timer().scheduleAtFixedRate(timmerTask, 0, 10000)
    timmerTask.run()
}

const val MAX_VALUE_IN_PROPERTY = 100