package com.example.atosrm.presentation.ui.elements.fab

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import com.example.atosrm.R


@OptIn(ExperimentalAnimationApi::class)
@Composable fun _FAB_content(
    modifier: Modifier,
    icon: Int,
    onAction: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .size(60.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .clickable { onAction() }
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {

        AnimatedContent(
            targetState = icon,
            transitionSpec = {
                if (targetState == R.drawable.edit_ic) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.background
            )

        }


    }
}