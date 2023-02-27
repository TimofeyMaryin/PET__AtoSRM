package com.example.atosrm.presentation.fr.show_full_info_person.module

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.fr.show_full_info_person.ShowPersonInfoViewModel
import com.example.atosrm.presentation.ui.elements.AppButton

@Composable fun EditButtonPlace(viewModel: ShowPersonInfoViewModel) {
    var editPerson by remember { mutableStateOf(0) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp, end = 15.dp), contentAlignment = Alignment.CenterEnd) {
        AppButton(
            value = "Edit",
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            ),
            borderColor = MaterialTheme.colorScheme.onBackground,
            textColor = MaterialTheme.colorScheme.onBackground
        ) {
             editPerson++
        }

    }


    LaunchedEffect(
        key1 = editPerson,
        block = {
            if (editPerson > 0) {
                viewModel.editPerson()
            }
        }
    )
}