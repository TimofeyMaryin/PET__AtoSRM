package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.fr.show_full_info_person.module.EditButtonPlace
import com.example.atosrm.presentation.fr.show_full_info_person.module.LoadedContent
import com.example.atosrm.presentation.ui.elements.AppButton
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun EditPersonFragment(
    viewModel: ShowPersonInfoViewModel
) {

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){

        item {
            if (
                viewModel.personName != null &&
                viewModel.personFullInfo != null &&
                viewModel.personSkills != null &&
                viewModel.personAvatar != null
            ) {
                LoadedContent(viewModel = viewModel)
            } else {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red), contentAlignment = Alignment.Center) {
                    LargeText(value = "Loading...")
                }
            }

        }

        item {
            EditButtonPlace(viewModel = viewModel)
        }

        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp))
        }
    }

    LaunchedEffect(key1 = Unit, block = { viewModel.initPerson() })

}





