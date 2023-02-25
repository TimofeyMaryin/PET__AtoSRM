package com.example.atosrm.presentation.fr.list_fragment.module

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.list_fragment.ListFragmentViewModel


@Composable fun ListOfPersonally(
    modifier: Modifier,
    mainViewModel: MainActivityViewModel
) {


    if(mainViewModel.usersList.isNotEmpty()) {
        ThereIsPerson(modifier = modifier, value = mainViewModel.usersList, viewModel = mainViewModel)
    } else {
        ThereIsNotPerson()
    }

}
