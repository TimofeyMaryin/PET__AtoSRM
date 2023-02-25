package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.data.state.PositionIconHeader
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.Header


@Composable fun EditPersonFragment(
    viewModel: ShowPersonInfoViewModel
) {
    val spacing = localSpacing.current
    var editInfo by remember { mutableStateOf(0) }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (header, editContent) = createRefs()

        Header(
            title = R.string.test_text,
            modifier = Modifier.constrainAs(header){},
            icon = R.drawable.save_as_ic,
            position = PositionIconHeader.END)
        {
            editInfo++
        }


        TextField(
            value = viewModel.valueEditInfo,
            onValueChange = { viewModel.valueEditInfo = it },
            modifier = Modifier
                .fillMaxWidth(localWidth.current.large)
                .constrainAs(editContent) {
                    top.linkTo(header.bottom, margin = spacing.medium)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }

    LaunchedEffect(
        key1 = editInfo,
        block = {
            if( editInfo > 0 ) {
                viewModel.editInfo()
                viewModel.navController.popBackStack()
            }
        }
    )

}