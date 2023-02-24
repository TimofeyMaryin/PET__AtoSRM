package com.example.atosrm.presentation.fr.search

import android.app.Application
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
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
        } else {
            item {
                __ThereIsNotContent(searchValue = viewModel.searchValue)
            }
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
        PersonallyItem(person = personSRM!!)
    }
}
@Composable private fun __Header(viewModel: SearchViewModel){
    Header(
        modifier = Modifier.fillMaxWidth(localWidth.current.large),
        icon = R.drawable.arrow_back_ic,
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
                ),
                trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer) }
            )

        }
    ) {
        // navController.popBackStack()
    }
}

@Composable private fun __ThereIsNotContent(searchValue: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LargeText(value = "We cant find $searchValue")
    }
}