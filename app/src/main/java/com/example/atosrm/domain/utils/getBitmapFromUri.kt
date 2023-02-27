package com.example.atosrm.domain.utils

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.IOException

@Throws(IOException::class)
fun getBitmapFromUri(context: Context, uri: Uri): Bitmap {
    val contentResolver: ContentResolver = context.contentResolver
    val inputStream = contentResolver.openInputStream(uri)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    inputStream?.close()
    return bitmap
}