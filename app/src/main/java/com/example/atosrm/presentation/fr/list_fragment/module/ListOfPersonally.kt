package com.example.atosrm.presentation.fr.list_fragment

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText
import com.example.atosrm.presentation.ui.elements.text.SmallText
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable fun ListOfPersonally(
    modifier: Modifier,
    viewModel: ListFragmentViewModel,
) {
    var currentUsers = remember { mutableListOf<PersonSRM>() }

    if (currentUsers.size != 0){
        ThereIsPerson(modifier = modifier, value = currentUsers)
    } else {
        ThereIsNotPerson()
    }

    LaunchedEffect(key1 = Unit, block = {
        currentUsers = viewModel.getAllList()
        Log.e("ListOfPersonally", "${currentUsers.size}", )
    })

}
