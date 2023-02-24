package com.example.atosrm.presentation.fr.list_fragment.module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.ui.elements.text.SmallText

@Composable fun ShortInfoItem(value: String) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .defaultMinSize(minHeight = 15.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        SmallText(
            value = value,
            modifier = Modifier.padding(vertical = 3.dp, horizontal = 8.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontStyle = FontStyle.Italic
        )
    }
}