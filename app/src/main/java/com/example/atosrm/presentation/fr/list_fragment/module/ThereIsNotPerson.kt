package com.example.atosrm.presentation.fr.list_fragment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.atosrm.R

@Composable fun ThereIsNotPerson(){
    val localWidth = LocalConfiguration.current.screenWidthDp
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.empty_list))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Int.MAX_VALUE
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        LottieAnimation(
            composition = composition,
            progress = progress,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(localWidth.dp)
        )

    }
}