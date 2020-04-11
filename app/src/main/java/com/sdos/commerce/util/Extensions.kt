package com.sdos.commerce.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
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