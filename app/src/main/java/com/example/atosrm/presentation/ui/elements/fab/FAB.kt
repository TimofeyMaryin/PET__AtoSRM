package com.example.atosrm.presentation.ui.elements.fab

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT

@OptIn(ExperimentalAnimationApi::class)
@Composable fun FAB(
    mainActivityViewModel: MainActivityViewModel,
    navController: NavController
) {
    var actionFab by remember { mutableStateOf(0) }

    AnimatedVisibility(
        visible = mainActivityViewModel.currentNavBackState == LIST_FRAGMENT || mainActivityViewModel.currentNavBackState == ADD_PERSON_FRAGMENT,
        enter = scaleIn(tween(400)) + fadeIn(tween(400)),
        exit = scaleOut(tween(400)) + fadeOut(tween(400))
    ) {
        _FAB_content(
            icon = if(mainActivityViewModel.isOpenNonMainMenuEl ) R.drawable.save_as_ic else R.drawable.edit_ic,
            modifier = Modifier,
        ) {
            actionFab++
        }
    }

    LaunchedEffect(key1 = actionFab, block = { if(actionFab != 0 ) mainActivityViewModel.fabButtonAction() })
}