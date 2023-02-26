package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.atosrm.R
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.ui.dimenston.localWidth
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
            Box(modifier = Modifier.fillMaxWidth().height(150.dp))
        }
    }

    LaunchedEffect(key1 = Unit, block = { viewModel.initPerson() })

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


@Composable fun EditableElement(
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
            verticalAlignment = Alignment.CenterVertically,
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


@Composable private fun LoadedContent(
    viewModel: ShowPersonInfoViewModel
){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(MaterialTheme.colorScheme.background)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    bitmap = viewModel.personAvatar!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        EditableElement(
            value = viewModel.personName!!,
            onChangeValue = { viewModel.personName = it },
            icon = R.drawable.person_ic
        )
        EditableElement(
            value = viewModel.personSkills!!,
            onChangeValue = { viewModel.personSkills = it },
            icon = R.drawable.skills_ic
        )
        EditableElement(
            value = viewModel.personFullInfo!!,
            onChangeValue = { viewModel.personFullInfo },
            icon = R.drawable.info_ic
        )

    }
}