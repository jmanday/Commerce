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

fun Long.toTypeResponse() =
    if (this != 0L)
        TypeResponse.Success()
    else
        TypeResponse.InsertError()


/*
 * This method is used for a Sealed class and it says the order of a subclass
 * inside the sealed class
 */
inline fun <reified T : Any> T.ordinal(): Int {
    if (T::class.isSealed) {
        return T::class.java.classes.indexOfFirst { sub -> sub == javaClass }
    }

    val klass = if (T::class.isCompanion) {
        javaClass.declaringClass
    } else {
        javaClass
    }

    return klass?.superclass?.classes?.indexOfFirst { it == klass } ?: -1
}