package com.example.atosrm.presentation.navigation

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.atosrm.presentation.fr.search.SearchViewModel
import com.example.atosrm.presentation.fr.show_full_info_person.ShowPersonSRMFragment


@RequiresApi(Build.VERSION_CODES.P)
@Composable fun AppNavHost(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    addPersonViewModel: AddPersonViewModel,
    listFragmentViewModel: ListFragmentViewModel,
    application: Application,
    searchViewModel: SearchViewModel
) {

    NavHost(
        navController = navController,
        startDestination = LIST_FRAGMENT
    ) {
        composable(LIST_FRAGMENT) { ListFragment(viewModel = listFragmentViewModel, mainViewModel = mainActivityViewModel) }
        composable(SETTINGS_FRAGMENT) {}
        composable(SEARCH_FRAGMENT) { SearchFragment(application = application, viewModel = searchViewModel, mainViewModel = mainActivityViewModel) }
        composable(ADD_PERSON_FRAGMENT) { AddPersonFragment(navController = navController, viewModel = addPersonViewModel, mainViewModel = mainActivityViewModel) }
        composable(PROFILE_FRAGMENT) { ProfileFragment() }
        composable(SHOW_PERSONAL_FRAGMENT) {
            ShowPersonSRMFragment(
                person = mainActivityViewModel.personToShow!!,
                mainViewModel = mainActivityViewModel
            )
        }
        composable(EDIT_PROFILE_FRAGMENT) {}
        composable(CREATE_POST_FRAGMENT) {}
    }

}