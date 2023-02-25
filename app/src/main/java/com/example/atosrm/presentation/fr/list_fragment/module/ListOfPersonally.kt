package com.example.atosrm.presentation.fr.list_fragment.module

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.list_fragment.ListFragmentViewModel


@Composable fun ListOfPersonally(
    modifier: Modifier,
    viewModel: ListFragmentViewModel,
    mainViewModel: MainActivityViewModel
) {
    var currentUsers by remember { mutableStateOf(listOf<PersonSRM>()) }


    if (currentUsers.isNotEmpty()){
        ThereIsPerson(
            modifier = modifier,
            value = currentUsers,
            viewModel = mainViewModel
        )
    } else {
        ThereIsNotPerson()
    }

    LaunchedEffect(key1 = Unit, block = {
        currentUsers = viewModel.getAllUser()

    })

}
