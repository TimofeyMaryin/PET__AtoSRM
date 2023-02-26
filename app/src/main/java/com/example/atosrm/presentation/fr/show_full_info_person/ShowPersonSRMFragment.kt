package com.example.atosrm.presentation.fr.show_full_info_person

import android.hardware.lights.Light
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.domain.utils.decodeBitmap
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.Header
import androidx.compose.ui.unit.dp
import com.example.atosrm.data.person_srm.PersonSRMDao
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.list_fragment.module.ShortInfoItem
import com.example.atosrm.presentation.navigation.EDIT_PERSON_INFO
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText
import okhttp3.internal.isSensitiveHeader


@Composable fun ShowPersonSRMFragment(
    navController: NavController,
    viewModel: ShowPersonInfoViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            PersonInfo(
                person = viewModel.mainViewModel.personToShow!!,
                viewModel = viewModel,
            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
        }
    }
}



@Composable private fun PersonInfo(
    person: PersonSRM,
    viewModel: ShowPersonInfoViewModel,
){
    val spacing = localSpacing.current
    var deletePersonTrigger by remember { mutableStateOf(0) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(localWidth.current.large)
    ) {


        val (topBar, avatar, skills, shortInfo, fullInfoRefs, deletePersonRefs) = createRefs()

        Header(
            title = person.fullName,
            modifier = Modifier.constrainAs(topBar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            icon = R.drawable.arrow_back_ic,
            position = PositionIconHeader.START
        ) {
            viewModel.mainViewModel.navController.popBackStack()
            viewModel.mainViewModel.currentNavBackState = LIST_FRAGMENT
        }

        Box(
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .constrainAs(avatar) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(
                        parent.end
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                bitmap = person.avatar.decodeBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(skills) {
                    top.linkTo(avatar.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultText(
                value = R.string.skills_description,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.width(12.dp))
            DefaultText(
                value = person.skills,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        }


        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 70.dp)
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .constrainAs(fullInfoRefs) {
                    top.linkTo(skills.bottom, margin = spacing.large)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Column(modifier = Modifier
                .fillMaxWidth(localWidth.current.extraLarge)
                .padding(vertical = 20.dp)) {
                LargeText(
                    value = stringResource(
                        id = R.string.about_person_description,
                        person.fullName
                    ),
                    modifier = Modifier.padding(start = 7.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Light
                )
                SelectionContainer {

                    DefaultText(
                        value = person.fullInfo,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 7.dp),
                        fontWeight = FontWeight.Light
                    )

                }
            }
        }

        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Blue)
                .height(70.dp)
                .constrainAs(shortInfo) {
                    top.linkTo(fullInfoRefs.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.CenterEnd,
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(person.shortInfo){
                    if (it.isNotEmpty()) {
                        Box(
                            modifier = Modifier.padding(horizontal = 7.dp),
                            contentAlignment = Alignment.Center
                        ){
                            ShortInfoItem(
                                value = it,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(deletePersonRefs) {
                    top.linkTo(shortInfo.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            contentAlignment = Alignment.CenterEnd
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Button(
                    onClick = {
                        viewModel.mainViewModel.personToShow = person
                        viewModel.mainViewModel.navController.navigate(EDIT_PERSON_INFO)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimaryContainer),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    LargeText(value = "Edit", color = MaterialTheme.colorScheme.onPrimaryContainer)
                }

                Spacer(modifier = Modifier.width(25.dp))

                Button(
                    onClick = { deletePersonTrigger++ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.errorContainer),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    LargeText(value = R.string.delete_person, color = MaterialTheme.colorScheme.errorContainer)
                }



            }
        }
    }



    LaunchedEffect(
        key1 = deletePersonTrigger,
        block = {
            if(deletePersonTrigger > 0 ) {
                viewModel.mainViewModel.deletePerson(personSRM = person)
            }
        }
    )

}