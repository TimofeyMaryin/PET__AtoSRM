package com.example.atosrm.presentation

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class MainActivityViewModel (
    private val navController: NavController,
    private val application: Application
): ViewModel() {

    var isOpenNonMainMenuEl by mutableStateOf(false)
    var currentNavBackState by mutableStateOf(LIST_FRAGMENT)

    fun fabButtonAction(){
        if (!isOpenNonMainMenuEl) {
            navController.navigate(ADD_PERSON_FRAGMENT)
            isOpenNonMainMenuEl = true
            currentNavBackState = ADD_PERSON_FRAGMENT
        } else {
            Toast.makeText(application, "Person is created", Toast.LENGTH_SHORT).show()
        }
    }


}