package com.sdos.commerce.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*

fun String.toBitmap(): Bitmap {
    val imageBytes = Base64.getMimeDecoder().decode(this)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}