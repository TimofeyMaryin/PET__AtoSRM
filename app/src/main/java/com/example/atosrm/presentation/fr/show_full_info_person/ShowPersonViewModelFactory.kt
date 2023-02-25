package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.atosrm.presentation.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class ShowPersonViewModelFactory(
    private val navController: NavController,
    private val mainViewModel: MainActivityViewModel,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowPersonInfoViewModel(
            navController = navController,
            mainViewModel = mainViewModel
        ) as T
    }

}