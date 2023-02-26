package com.example.atosrm.presentation.fr.show_full_info_person.module

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.presentation.fr.show_full_info_person.ShowPersonInfoViewModel
import com.example.atosrm.presentation.ui.elements.AppButton
import com.example.atosrm.presentation.ui.elements.text.LargeText

@Composable fun LoadedContent(
    viewModel: ShowPersonInfoViewModel
){

    ConstraintLayout(
        modifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        val (header, avatar, personValue) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(MaterialTheme.colorScheme.background)
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            LargeText(
                value = R.string.edit_person_fragment_edit,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(
                        6.dp,
                        MaterialTheme.colorScheme.onSecondary
                    ),
                    CircleShape
                )
                .clip(CircleShape)
                .size(150.dp)
                .constrainAs(avatar) {
                    top.linkTo(header.bottom, margin = (-75).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center,
        ) {

            Image(
                bitmap = viewModel.personAvatar!!.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.constrainAs(personValue) {
                top.linkTo(avatar.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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

}