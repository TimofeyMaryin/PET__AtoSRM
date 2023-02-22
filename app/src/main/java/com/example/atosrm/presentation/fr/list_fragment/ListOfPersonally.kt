package com.example.atosrm.presentation.fr.list_fragment

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.presentation.ui.dimenston.LocalSpacing
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText
import com.example.atosrm.presentation.ui.elements.text.SmallText
import androidx.compose.ui.unit.dp


@Composable fun ListOfPersonally(
    modifier: Modifier,
    viewModel: ListFragmentViewModel,
) {
    var currentUsers = remember { mutableListOf<PersonSRM>() }

    if (currentUsers.size != 0){
        ThereIsPerson(modifier = modifier, value = currentUsers)
    } else {
        ThereIsNotPerson()
    }

    LaunchedEffect(key1 = Unit, block = {
        currentUsers = viewModel.getAllList()
        Log.e("ListOfPersonally", "${currentUsers.size}", )
    })

}

@Composable private fun ThereIsPerson(
    modifier: Modifier,
    value: MutableList<PersonSRM>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(value) {
            Container {
                PersonallyItem(person = it)
            }
        }
    }
}
@Composable private fun ThereIsNotPerson(){

}
@Composable private fun PersonallyItem(person: PersonSRM) {
    val spacing = localSpacing.current
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { }
            .fillMaxWidth(localWidth.current.extraLarge),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(localWidth.current.large),
        ) {
            val (icon, personName, skills, shortInfo, exitButton) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(icon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top, margin = spacing.small)
                    }
                    .size(40.dp)
            )

            LargeText(
                value = person.fullName,
                modifier = Modifier.constrainAs(personName) {
                    top.linkTo(icon.top, margin = (-10).dp)
                    start.linkTo(icon.end, margin = spacing.small)
                },
            )

            DefaultText(value = person.skills, modifier = Modifier.constrainAs(skills) {
                top.linkTo(personName.bottom)
                start.linkTo(icon.end, margin = spacing.small)
            })

            SmallText(value = person.shortInfo[0], modifier = Modifier.constrainAs(shortInfo) {
                top.linkTo(skills.bottom)
                start.linkTo(icon.end, margin = spacing.small)
            })

            Icon(
                painter = painterResource(id = R.drawable.read_more),
                contentDescription = null,
                modifier = Modifier.constrainAs(exitButton) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}


@Composable
private fun Container(content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 2.dp), contentAlignment = Alignment.Center, content = { content() })
}

