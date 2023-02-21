package com.example.atosrm.presentation.ui.dimenston

import androidx.compose.runtime.compositionLocalOf


data class LocalWidth(
    val default: Float = 1.0f,
    val extraLarge: Float = 0.99f,
    val large: Float = 0.95f
)

val localWidth = compositionLocalOf { LocalWidth() }