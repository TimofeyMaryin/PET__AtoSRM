package com.example.atosrm.presentation.ui.elements.bottom_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.navigation.PROFILE_FRAGMENT
import com.example.atosrm.presentation.navigation.SEARCH_FRAGMENT


@Composable fun BottomBar(
    navController: NavController,
    modifier: Modifier,
) {
    val currentRoute by remember { mutableStateOf( navController.currentDestination?.route) }


    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarItem(
            isActive = currentRoute == LIST_FRAGMENT,
            icon = R.drawable.list_ic,
            nameOfPage = R.string.menu_list_name
        ) {
            navController.navigate(LIST_FRAGMENT)
        }

        BottomBarItem(
            isActive = currentRoute == SEARCH_FRAGMENT,
            icon = R.drawable.search_ic,
            nameOfPage = R.string.menu_search_name
        ) {
            navController.navigate(SEARCH_FRAGMENT)
        }

        BottomBarItem(
            isActive = currentRoute == PROFILE_FRAGMENT,
            icon = R.drawable.accaunt_ic,
            nameOfPage = R.string.menu_profile_name
        ) {
            navController.navigate(LIST_FRAGMENT)
        }
    }

}