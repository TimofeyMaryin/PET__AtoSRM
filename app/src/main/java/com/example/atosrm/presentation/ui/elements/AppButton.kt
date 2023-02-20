package com.example.atosrm.presentation.ui.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.atosrm.presentation.ui.elements.text.LargeText
import androidx.compose.ui.unit.dp


@Composable fun AppButton(
    value: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) =
    Button(
        onClick = { onClick() },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        LargeText(value = value, color = MaterialTheme.colorScheme.primary)
    }


@Composable
@Preview(widthDp = 200)
fun PreviewButton() {
    AppButton(value = "Test") {}
}