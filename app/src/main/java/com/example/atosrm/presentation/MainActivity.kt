package com.example.atosrm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.atosrm.R
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.AppNavHost
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.ui.elements.FAB
import com.example.atosrm.presentation.ui.elements.bottom_bar.BottomBar
import com.example.atosrm.presentation.ui.theme.AtoSRMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { contents() }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable private fun contents() {
    val mainActivityViewModel: MainActivityViewModel = viewModel()
    val navController = rememberNavController()
    var currentFABIcon by remember {
        mutableStateOf(R.drawable.edit_ic)
    }

    AtoSRMTheme {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {},
            floatingActionButton = {
                if (mainActivityViewModel.currentNavBackState == LIST_FRAGMENT || mainActivityViewModel.currentNavBackState == ADD_PERSON_FRAGMENT) {

                    FAB(
                        icon = if(mainActivityViewModel.isOpenNonMainMenuEl ) R.drawable.save_as_ic else R.drawable.edit_ic,
                        modifier = Modifier,
                    ) {
                        navController.navigate(ADD_PERSON_FRAGMENT)
                        mainActivityViewModel.isOpenNonMainMenuEl = true
                        mainActivityViewModel.currentNavBackState = ADD_PERSON_FRAGMENT

                    }
                }
            },
            bottomBar = { BottomBar(
                navController = navController,
                modifier = Modifier,
                viewModel = mainActivityViewModel
            ) },
            content = { it -> AppNavHost(navController = navController, mainActivityViewModel = mainActivityViewModel) }
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