package com.example.atosrm.presentation.ui.dimenston

import androidx.compose.runtime.compositionLocalOf


data class LocalWidth(
    val default: Float = 1.0f,
    val extraLarge: Float = 0.98f,
    val large: Float = 0.90f
)

val localWidth = compositionLocalOf { LocalWidth() }