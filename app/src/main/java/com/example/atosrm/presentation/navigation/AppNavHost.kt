package com.example.atosrm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonFragment
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.fr.list_fragment.ListFragment
import com.example.atosrm.presentation.fr.list_fragment.ListFragmentViewModel
import com.example.atosrm.presentation.fr.profile.ProfileFragment
import com.example.atosrm.presentation.fr.search.SearchFragment


@Composable fun AppNavHost(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    addPersonViewModel: AddPersonViewModel,
    listFragmentViewModel: ListFragmentViewModel,
) {

    NavHost(
        navController = navController,
        startDestination = LIST_FRAGMENT
    ) {
        composable(LIST_FRAGMENT) { ListFragment(navController = navController, viewModel = listFragmentViewModel) }
        composable(SETTINGS_FRAGMENT) {}
        composable(SEARCH_FRAGMENT) { SearchFragment() }
        composable(ADD_PERSON_FRAGMENT) { AddPersonFragment(navController = navController, viewModel = addPersonViewModel, mainViewModel = mainActivityViewModel) }
        composable(PROFILE_FRAGMENT) { ProfileFragment() }
        composable(SHOW_PERSONAL_FRAGMENT) {}
        composable(EDIT_PROFILE_FRAGMENT) {}
        composable(CREATE_POST_FRAGMENT) {}
    }

}