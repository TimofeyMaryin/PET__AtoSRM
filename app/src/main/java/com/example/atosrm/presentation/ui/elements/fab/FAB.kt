package com.example.atosrm.presentation.ui.elements.fab

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT

@Composable fun FAB(
    mainActivityViewModel: MainActivityViewModel,
    navController: NavController
) {
    AnimatedVisibility(
        visible = mainActivityViewModel.currentNavBackState == LIST_FRAGMENT || mainActivityViewModel.currentNavBackState == ADD_PERSON_FRAGMENT,
        enter = slideInVertically(tween(400)) { it / 2 } + fadeIn(tween(400)),
        exit = slideOutVertically(tween(400)) { it / 2 } + fadeOut(tween(400))
    ) {
        _FAB_content(
            icon = if(mainActivityViewModel.isOpenNonMainMenuEl ) R.drawable.save_as_ic else R.drawable.edit_ic,
            modifier = Modifier,
        ) {
            navController.navigate(ADD_PERSON_FRAGMENT)
            mainActivityViewModel.isOpenNonMainMenuEl = true
            mainActivityViewModel.currentNavBackState = ADD_PERSON_FRAGMENT

        }
    }
}