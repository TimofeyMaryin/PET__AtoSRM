package com.example.atosrm.presentation.fr.add_person_srm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.atosrm.R
import androidx.compose.ui.unit.dp
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.Header
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun AddPersonFragment(
    navController: NavController,
    viewModel: AddPersonViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Header(
                title = R.string.header_title_add_person,
                modifier = Modifier,
                icon = R.drawable.arrow_back_ic,
                position = PositionIconHeader.START,
            ) {
                    navController.popBackStack()
            }
        }

        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                        .clickable { }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    
                }
                LargeText(value = R.string.avatar)
            }
        }

//        items(viewModel.textFieldInfo) {
//            Container {
//                AppTextField(placeHolder = it.placeHolder, desc = it.descriptor, value = it.value, onChangeValue = { value -> it.value = value })
//            }
//        }
        item {
            Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[0].placeHolder,
                    desc = viewModel.textFieldInfo[0].descriptor,
                    value = viewModel.personName,
                    onChangeValue = { viewModel.personName = it },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
            }
            Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[1].placeHolder,
                    desc = viewModel.textFieldInfo[1].descriptor,
                    value = viewModel.personSkills,
                    onChangeValue = { viewModel.personSkills = it },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
            }
            Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[2].placeHolder,
                    desc = viewModel.textFieldInfo[2].descriptor,
                    value = viewModel.personInfo,
                    onChangeValue = { viewModel.personInfo = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

@Composable private fun Container(content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth(localWidth.current.large)
        .padding(vertical = localSpacing.current.small), contentAlignment = Alignment.Center) {
        content()
    }
}

