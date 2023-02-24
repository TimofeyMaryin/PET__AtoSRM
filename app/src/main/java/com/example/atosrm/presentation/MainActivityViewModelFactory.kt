package com.example.atosrm.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(
    private val navController: NavController,
    private val application: Application,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(navController = navController, application = application) as T
    }

}