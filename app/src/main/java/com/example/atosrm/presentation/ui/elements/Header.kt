package com.example.atosrm.presentation.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun Header(
    title: Int,
    modifier: Modifier,
    icon: Int,
    position: PositionIconHeader,
    onAction: () -> Unit,
) {
    val currentWidth = localWidth.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth(currentWidth.large)
            .then(modifier)
    ) {
        val (iconRefs, titleRefs) = createRefs()

        LargeText(
            value = stringResource(id = title),
            modifier = Modifier.constrainAs(titleRefs) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            },
            color = MaterialTheme.colorScheme.surfaceVariant
        )
        IconButton(
            onClick = { onAction() },
            modifier = Modifier.constrainAs(iconRefs){
                when(position) {
                    PositionIconHeader.START -> {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.top)
                    }
                    PositionIconHeader.END -> {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    else -> {}
                }
            }
        ) {
            if (position != PositionIconHeader.NOTHING) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }


    }

}


