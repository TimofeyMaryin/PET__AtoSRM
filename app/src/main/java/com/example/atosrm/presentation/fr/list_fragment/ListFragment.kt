package com.example.atosrm.presentation.fr.list_fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.atosrm.R
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.fr.list_fragment.module.ListOfPersonally
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.elements.Header


@Composable fun ListFragment(
    mainViewModel: MainActivityViewModel
) {
    val spacing = localSpacing.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val (topBar,content) = createRefs()


        Header(
            title = R.string.list_header_name,
            modifier = Modifier.constrainAs(topBar) { top.linkTo(parent.top) }.padding(vertical = spacing.small),
            icon = R.drawable.setting_ic,
            position = PositionIconHeader.END
        ) {
            // TODO("Impl navigation to Setting")
        }

        ListOfPersonally(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(topBar.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            mainViewModel = mainViewModel
        )

    }
}