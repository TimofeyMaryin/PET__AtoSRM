package com.example.atosrm.presentation.fr.add_person_srm.module

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.text.SmallText
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.ui.dimenston.localSpacing

@Composable fun AddPersonShortInfoContainer(
    viewModel: AddPersonViewModel
) {
    _Add_Person_Container {
        Column(
            modifier = Modifier.clip(MaterialTheme.shapes.medium).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTextField(
                placeHolder = R.string.place_holder_short_info,
                desc = R.string.description_short_info,
                value = viewModel.shortInfo,
                onChangeValue = { viewModel.shortInfo = it }
            )
            ListShortInfoContainer(viewModel = viewModel)

        }
    }
}



@Composable private fun ListShortInfoContainer(viewModel: AddPersonViewModel){
    val localPadding = localSpacing.current
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 70.dp)
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        val (limitRefs, rawRefs) = createRefs()

        SmallText(
            value = R.string.limit_short_info,
            modifier = Modifier.constrainAs(limitRefs) {
                end.linkTo(parent.end, margin = localPadding.small)
                bottom.linkTo(parent.bottom, margin = localPadding.small)
            }
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(rawRefs) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            items(viewModel.shortInfoToList().size) {
                ShortInfoChip(
                    value = viewModel.shortInfoToList()[it],
                    onDeleteItem = {
                        viewModel.deleteShortInfoItem(it)
                        Log.e("ListShortInfoContainer", "count items: ${viewModel.shortInfoToList().size}", )
                    }
                )
            }
        }

    }

}

@Composable private fun ShortInfoChip(
    value: String,
    onDeleteItem: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SmallText(value = value)

        IconButton(
            onClick = {
                onDeleteItem()
            }
        ) {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
        }
    }

}