package com.example.atosrm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.atosrm.R
import com.example.atosrm.presentation.navigation.AppNavHost
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
    val navController = rememberNavController()
    AtoSRMTheme {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {},
            floatingActionButton = {
                FAB(
                    icon = R.drawable.edit_ic,
                    modifier = Modifier,
                ) {
                    // TODO("Impl this feat")
                }
            },
            bottomBar = { BottomBar(navController = navController, modifier = Modifier) },
            content = { it -> AppNavHost(navController = navController) }
        )

    }
}