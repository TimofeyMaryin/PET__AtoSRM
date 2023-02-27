package com.example.atosrm.domain.utils

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

fun saveImage(bitmap: Bitmap): ByteArray {
    val data = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, data)

    return data.toByteArray()
}