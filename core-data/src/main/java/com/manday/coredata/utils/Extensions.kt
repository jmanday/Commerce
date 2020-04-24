package com.manday.coredata.utils


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