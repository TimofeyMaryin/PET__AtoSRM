package com.example.atosrm.domain.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun ByteArray.decodeBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, size)
}