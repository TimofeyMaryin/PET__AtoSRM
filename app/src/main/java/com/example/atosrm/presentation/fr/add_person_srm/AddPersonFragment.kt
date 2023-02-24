package com.example.atosrm.presentation.fr.add_person_srm

import android.app.Instrumentation.ActivityResult
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.atosrm.R
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.add_person_srm.module.AddPersonShortInfoContainer
import com.example.atosrm.presentation.fr.add_person_srm.module._Add_Person_Container
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.AppButton
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.Header
import com.example.atosrm.presentation.ui.elements.text.LargeText


@OptIn(ExperimentalFoundationApi::class)
@Composable fun AddPersonFragment(
    navController: NavController,
    viewModel: AddPersonViewModel,
    mainViewModel: MainActivityViewModel
) {

    var selectImage by remember { mutableStateOf<Uri?>(null) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            selectImage = uri
            viewModel.imageUriString = uri.toString()
        }
    )

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stickyHeader {
            Header(
                title = R.string.header_title_add_person,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .defaultMinSize(minHeight = 80.dp),
                icon = R.drawable.arrow_back_ic,
                position = PositionIconHeader.START,
            ) {
                navController.popBackStack()
                mainViewModel.currentNavBackState = LIST_FRAGMENT
                mainViewModel.isOpenNonMainMenuEl = false
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
                        .clickable { galleryLauncher.launch("image/*") }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter =  rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(data = selectImage)
                                .build()
                        ),
                        contentDescription = null,
                    )

                }
                LargeText(value = R.string.avatar)
            }
        }

        item {
            _Add_Person_Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[0].placeHolder,
                    desc = viewModel.textFieldInfo[0].descriptor,
                    value = viewModel.personName,
                    onChangeValue = { viewModel.personName = it },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
            }
            _Add_Person_Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[1].placeHolder,
                    desc = viewModel.textFieldInfo[1].descriptor,
                    value = viewModel.personSkills,
                    onChangeValue = { viewModel.personSkills = it },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
            }
            _Add_Person_Container {
                AppTextField(
                    placeHolder = viewModel.textFieldInfo[2].placeHolder,
                    desc = viewModel.textFieldInfo[2].descriptor,
                    value = viewModel.personInfo,
                    onChangeValue = { viewModel.personInfo = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }

        item {
            AddPersonShortInfoContainer(viewModel = viewModel)
        }
        

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Box(modifier = Modifier.padding(horizontal = localSpacing.current.medium), contentAlignment = Alignment.Center) {
                    AppButton(value = "Add tags") {
                        if(viewModel.shortInfo.isNotEmpty()) viewModel.addInfoToList()
                    }
                }

                Box(modifier = Modifier.padding(horizontal = localSpacing.current.medium), contentAlignment = Alignment.Center){
                    AppButton(value = "ADd person") {

                    }
                }


            }
        }

        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
        }
    }
}






