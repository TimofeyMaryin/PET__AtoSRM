package com.example.atosrm.presentation.fr.add_person

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.Header


@Composable fun AddPersonFragment(
    navController: NavController,
    viewModel: AddPersonViewModel
) {
    val spacing = localSpacing.current
    val width = localWidth.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Header(
                title = R.string.add_person_header_name,
                modifier = Modifier.fillMaxWidth(width.large),
                icon = R.drawable.arrow_back_ic,
                position = PositionIconHeader.START
            ) { navController.popBackStack() }
        }

        item {
            AppPersonContent(viewModel = viewModel)
        }
    }
}