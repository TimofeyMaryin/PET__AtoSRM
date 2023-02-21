package com.example.atosrm.presentation.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable fun FAB(
    icon: Int,
    onAction: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .size(60.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .clickable { onAction() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background
        )
    }
}