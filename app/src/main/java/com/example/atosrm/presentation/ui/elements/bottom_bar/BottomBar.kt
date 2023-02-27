package com.example.atosrm.presentation.ui.elements.bottom_bar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.navigation.PROFILE_FRAGMENT
import com.example.atosrm.presentation.navigation.SEARCH_FRAGMENT
import com.example.atosrm.presentation.ui.dimenston.localSpacing


@Composable fun BottomBar(
    navController: NavController,
    modifier: Modifier,
    viewModel: MainActivityViewModel
) {
    val spacing = localSpacing.current


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondary)
            .then(modifier)
            .padding(vertical = spacing.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarItem(
            isActive = viewModel.currentNavBackState == LIST_FRAGMENT || viewModel.currentNavBackState == ADD_PERSON_FRAGMENT,
            icon = R.drawable.list_ic,
            nameOfPage = R.string.menu_list_name
        ) {
            if(viewModel.currentNavBackState != LIST_FRAGMENT || viewModel.isOpenNonMainMenuEl){
                viewModel.isOpenNonMainMenuEl = false
                viewModel.currentNavBackState = LIST_FRAGMENT
                navController.navigate(LIST_FRAGMENT)
            }
        }

        BottomBarItem(
            isActive = viewModel.currentNavBackState == SEARCH_FRAGMENT,
            icon = R.drawable.search_ic,
            nameOfPage = R.string.menu_search_name
        ) {
            if(viewModel.currentNavBackState != SEARCH_FRAGMENT || viewModel.isOpenNonMainMenuEl) {
                viewModel.isOpenNonMainMenuEl = false
                viewModel.currentNavBackState = SEARCH_FRAGMENT
                navController.navigate(SEARCH_FRAGMENT)
            }
        }
        
    }

}