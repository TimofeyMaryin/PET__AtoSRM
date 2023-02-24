package com.example.atosrm.presentation.fr.search

import android.app.Application
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.atosrm.R
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.list_fragment.module.PersonallyItem
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.Header
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText


@OptIn(ExperimentalFoundationApi::class)
@Composable fun SearchFragment(
    viewModel: SearchViewModel,
    application: Application,
) {
    var searchItem by remember { mutableStateOf(listOf<PersonSRM>()) }

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        stickyHeader {
            __Header(viewModel = viewModel)
        }

        if (searchItem.isNotEmpty() && viewModel.searchValue.isNotEmpty()) {
            items(searchItem){
                __ThereIsContent(personSRM = it)
            }
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    DefaultText(
                        value = stringResource(
                            R.string.hint_how_find_element,
                            searchItem.size
                        ),
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        } else {
            item {
                if (viewModel.searchValue.isEmpty()) {
                    __DefaultScreenWithoutSearch()
                } else {
                    __ThereIsNotContent(searchValue = viewModel.searchValue)
                }

            }
        }

        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
        }
    }


    LaunchedEffect(
        key1 = viewModel.searchValue,
        block = {
            searchItem = viewModel
                .searchPerson(
                    application = application,
                    searchValue = viewModel.searchValue
                )
            Log.e("SearchFragment:", searchItem.size.toString(), )
        }
    )
}


@Composable private fun __ThereIsContent(personSRM: PersonSRM) {
    Box(
        modifier = Modifier
            .fillMaxWidth(localWidth.current.extraLarge)
            .padding(vertical = 7.dp),
        contentAlignment = Alignment.Center
    ){
        PersonallyItem(person = personSRM)
    }
}
@Composable private fun __Header(viewModel: SearchViewModel){
    Header(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .fillMaxWidth(localWidth.current.large)
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp),
        icon = -1,
        position = PositionIconHeader.START,
        centerContent = {

            OutlinedTextField(
                value = viewModel.searchValue ,
                onValueChange = { viewModel.changeSearchValue(it) },
                placeholder = { DefaultText(value = R.string.place_holder_search_text_field) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,

                    unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                    disabledBorderColor = MaterialTheme.colorScheme.primaryContainer,
                    errorBorderColor = MaterialTheme.colorScheme.primaryContainer,

                    placeholderColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                trailingIcon = {
                    IconButton(onClick = { if(viewModel.searchValue.isNotEmpty()) viewModel.cleanSearchBar() }) {
                        Icon(
                            imageVector = if( viewModel.searchValue.isEmpty() ) Icons.Default.Search else Icons.Default.Delete,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            )

        }
    ) {
        // navController.popBackStack()
    }
}

@Composable private fun __ThereIsNotContent(searchValue: String) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.not_found))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Int.MAX_VALUE
    )
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (animateRefs, textRefs) = createRefs()

        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.constrainAs(animateRefs) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            alignment = Alignment.Center
        )

        LargeText(
            value = stringResource(
                id = R.string.hint_not_found_element,
                searchValue
            ),
            modifier = Modifier.constrainAs(textRefs) {
                top.linkTo(animateRefs.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable private fun __DefaultScreenWithoutSearch(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        LargeText(
            value = R.string.hint_search_empty_element,
            color = MaterialTheme.colorScheme.primary
        )
    }
}