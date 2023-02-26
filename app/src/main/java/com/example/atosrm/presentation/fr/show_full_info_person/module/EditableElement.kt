package com.example.atosrm.presentation.fr.show_full_info_person.module

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.ui.dimenston.localWidth

@Composable
fun EditableElement(
    value: String,
    onChangeValue: (String) -> Unit,
    icon: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(localWidth.current.large),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )
            AppTextField(
                value = value,
                modifier = Modifier.weight(3f),
                onChangeValue = {onChangeValue(it)}
            )
        }

    }
}


@Composable private fun AppTextField(
    value: String,
    modifier: Modifier,
    onChangeValue: (String) -> Unit,
) =
    OutlinedTextField(
        value = value,
        onValueChange = { onChangeValue(it) },
        modifier = modifier
    )


