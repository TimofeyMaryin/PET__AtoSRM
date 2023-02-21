package com.example.atosrm.presentation.fr.add_person_srm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun AddPersonFragment() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LargeText(
            value = "Add person",
            color = MaterialTheme.colorScheme.error
        )
    }
}