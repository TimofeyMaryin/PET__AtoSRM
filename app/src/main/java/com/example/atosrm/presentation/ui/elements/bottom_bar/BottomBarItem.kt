package com.example.atosrm.presentation.ui.elements.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun BottomBarItem(
    isActive: Boolean,
    icon: Int,
    nameOfPage: Int,
    onAction: () -> Unit
) {
     Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier.clickable { onAction() }
     ) {
         Box(
             modifier = Modifier
                 .clip(MaterialTheme.shapes.medium)
                 .background(if (isActive) MaterialTheme.colorScheme.background else Color.Transparent),
             contentAlignment = Alignment.Center
         ) {
             Icon(
                 painter = painterResource(id = icon),
                 contentDescription = null,
                 tint = if (isActive) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.background
             )
         }

         LargeText(value = stringResource(id = nameOfPage), color = MaterialTheme.colorScheme.background)
     }
}