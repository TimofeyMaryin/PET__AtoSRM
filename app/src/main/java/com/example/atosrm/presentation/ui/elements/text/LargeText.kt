package com.example.atosrm.presentation.ui.elements.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.atosrm.presentation.ui.font.notoSans
import androidx.compose.ui.unit.sp


@Composable fun LargeText(
    value: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = MaterialTheme.colorScheme.background,
    fontStyle: FontStyle = FontStyle.Normal,
) =
    Text(
        text = value,
        fontWeight = fontWeight,
        fontFamily = notoSans,
        color = color,
        modifier = modifier,
        fontSize = 18.sp,
        fontStyle = fontStyle,
    )


@Composable fun LargeText(
    value: Int,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontStyle: FontStyle = FontStyle.Normal,
) =
    Text(
        text = stringResource(id = value),
        fontWeight = fontWeight,
        fontFamily = notoSans,
        color = color,
        modifier = modifier,
        fontSize = 18.sp,
        fontStyle = fontStyle
    )