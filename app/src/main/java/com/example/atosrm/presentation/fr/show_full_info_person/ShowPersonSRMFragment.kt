package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
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
import com.example.atosrm.presentation.fr.list_fragment.module.ShortInfoItem
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText
import okhttp3.internal.isSensitiveHeader


@Composable fun ShowPersonSRMFragment(
    person: PersonSRM,
    navController: NavController,
    dao: PersonSRMDao
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            PersonInfo(
                person = person,
                navController = navController,
                dao = dao
            )
        }
    }
}



@Composable private fun PersonInfo(
    person: PersonSRM,
    navController: NavController,
    dao: PersonSRMDao
){
    val spacing = localSpacing.current
    var deletePersonTrigger by remember { mutableStateOf(0) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(localWidth.current.large)
    ) {


        val (topBar, avatar, fullName, skills, shortInfo, fullInfoRefs, deletePersonRefs) = createRefs()

        Header(
            title = R.string.person_name,
            params = person.fullName,
            modifier = Modifier.constrainAs(topBar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            icon = R.drawable.arrow_back_ic,
            position = PositionIconHeader.START
        ) {
            navController.popBackStack()
        }

        Image(
            bitmap = person.avatar.decodeBitmap().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .constrainAs(avatar) {
                    top.linkTo(topBar.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                }
        )

        LargeText(
            value = person.fullName,
            modifier = Modifier.constrainAs(fullName) {
                top.linkTo(avatar.top)
                start.linkTo(avatar.end)
            },
            color = MaterialTheme.colorScheme.onPrimary
        )

        DefaultText(
            value = person.skills,
            modifier = Modifier.constrainAs(skills) {
                top.linkTo(fullName.bottom)
                start.linkTo(avatar.end)
            }
        )


        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .constrainAs(fullInfoRefs) {
                    top.linkTo(avatar.bottom, margin = spacing.large)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            LargeText(
                value = person.fullInfo,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(shortInfo) {
                    top.linkTo(fullName.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(person.shortInfo){
                Box(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    contentAlignment = Alignment.Center
                ){
                    ShortInfoItem(value = it)
                }
            }
        }

        IconButton(
            onClick = {
                deletePersonTrigger++
            },
            modifier = Modifier.constrainAs(deletePersonRefs) {
                top.linkTo(shortInfo.bottom, margin = spacing.medium)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(50.dp)
            )
        }
    }



    LaunchedEffect(
        key1 = deletePersonTrigger,
        block = {
            if(deletePersonTrigger > 0 ) {
                dao.deletePerson(person = person)
                navController.popBackStack()
            }
        }
    )

}