package com.example.atosrm.presentation.fr.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun SearchFragment() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center){
        LargeText(value = "Search Fragment")
    }
}