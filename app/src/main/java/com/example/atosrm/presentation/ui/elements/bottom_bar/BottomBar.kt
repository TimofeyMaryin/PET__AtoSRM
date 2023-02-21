package com.example.atosrm.presentation.ui.elements.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.example.atosrm.presentation.ui.dimenston.localSpacing


@Composable fun BottomBar(
    navController: NavController,
    modifier: Modifier,
) {
    val currentRoute by remember { mutableStateOf( navController.currentDestination?.route) }
    val spacing = localSpacing.current


    Row(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.onSecondary).then(modifier).padding(vertical = spacing.small),
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