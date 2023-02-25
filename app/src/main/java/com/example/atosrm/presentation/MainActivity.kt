package com.example.atosrm.presentation

import android.app.Application
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.atosrm.R
import com.example.atosrm.data.ApplicationDataBase
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.fr.list_fragment.ListFragmentViewModel
import com.example.atosrm.presentation.fr.list_fragment.ListViewModelFactory
import com.example.atosrm.presentation.fr.search.SearchViewModel
import com.example.atosrm.presentation.fr.show_full_info_person.ShowPersonInfoViewModel
import com.example.atosrm.presentation.fr.show_full_info_person.ShowPersonViewModelFactory
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.AppNavHost
import com.example.atosrm.presentation.ui.elements.bottom_bar.BottomBar
import com.example.atosrm.presentation.ui.elements.fab.FAB
import com.example.atosrm.presentation.ui.theme.AtoSRMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { contents(application = application) }

    }
}


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable private fun contents(application: Application) {
    val dao = ApplicationDataBase.getInstance(application).personSRMDao()

    val listFragmentViewModel: ListFragmentViewModel = viewModel(
        factory = ListViewModelFactory(
            dao = dao
        )
    )
    val searchViewModel: SearchViewModel = viewModel()
    val addPersonViewModel: AddPersonViewModel = hiltViewModel()
    val navController = rememberNavController()
    val mainActivityViewModel: MainActivityViewModel = viewModel(
        factory = MainActivityViewModelFactory(
            navController = navController,
            application = application,
            dao = dao,
            addPersonViewModel = addPersonViewModel
        )
    )
    val showPersonViewModel: ShowPersonInfoViewModel = viewModel(
        factory = ShowPersonViewModelFactory(
            navController = navController,
            mainViewModel = mainActivityViewModel
        )
    )
    var currentFABIcon by remember {
        mutableStateOf(R.drawable.edit_ic)
    }

    AtoSRMTheme {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {},
            floatingActionButton = {
                FAB(mainActivityViewModel = mainActivityViewModel, navController = navController)
            },
            bottomBar = { BottomBar(
                navController = navController,
                modifier = Modifier,
                viewModel = mainActivityViewModel
            ) },
            content = { it ->
                AppNavHost(
                    navController = navController,
                    mainActivityViewModel = mainActivityViewModel,
                    addPersonViewModel = addPersonViewModel,
                    application = application,
                    searchViewModel = searchViewModel,
                    showPersonInfoViewModel = showPersonViewModel
                )
            }
        )


        LaunchedEffect(
            key1 = mainActivityViewModel.currentNavBackState,
            block = {
                    currentFABIcon = when(mainActivityViewModel.currentNavBackState){
                        ADD_PERSON_FRAGMENT -> R.drawable.save_as_ic
                        else -> R.drawable.edit_ic
                    }
            },
        )

    }
}