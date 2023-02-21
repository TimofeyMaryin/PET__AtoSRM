package com.example.atosrm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.atosrm.presentation.fr.list_fragment.ListFragment


@Composable fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = LIST_FRAGMENT
    ) {
        composable(LIST_FRAGMENT) { ListFragment(navController = navController) }
        composable(SETTINGS_FRAGMENT) {}
        composable(SEARCH_FRAGMENT) {}
        composable(ADD_PERSON_FRAGMENT) {}
        composable(PROFILE_FRAGMENT) {}
        composable(SHOW_PERSONAL_FRAGMENT) {}
        composable(EDIT_PROFILE_FRAGMENT) {}
        composable(CREATE_POST_FRAGMENT) {}
    }

}