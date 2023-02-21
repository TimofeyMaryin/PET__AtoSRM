package com.example.atosrm.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import dagger.hilt.android.lifecycle.HiltViewModel



class MainActivityViewModel: ViewModel() {

    var isOpenNonMainMenuEl by mutableStateOf(false)
    var currentNavBackState by mutableStateOf(LIST_FRAGMENT)

}