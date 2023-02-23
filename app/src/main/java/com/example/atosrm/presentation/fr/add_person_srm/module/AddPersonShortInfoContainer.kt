package com.example.atosrm.presentation.fr.add_person_srm.module

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.atosrm.R
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.text.SmallText
import androidx.compose.ui.unit.dp
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.theme.Primary40
import com.example.atosrm.presentation.ui.theme.Primary95
import kotlinx.coroutines.delay

@Composable fun AddPersonShortInfoContainer(
    viewModel: AddPersonViewModel
) {
    _Add_Person_Container {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTextField(
                placeHolder = R.string.place_holder_short_info,
                desc = R.string.description_short_info,
                value = viewModel.shortInfo,
                onChangeValue = { if(it.length <= 8) viewModel.shortInfo = it }
            )

            Box(modifier = Modifier.fillMaxWidth().padding(vertical = localSpacing.current.large), contentAlignment = Alignment.Center) {
                ListShortInfoContainer(viewModel = viewModel)
            }


        }
    }
}



@Composable private fun ListShortInfoContainer(viewModel: AddPersonViewModel){
    val localPadding = localSpacing.current

    var currentListShortInfo = remember { viewModel.shortInfoMutableList }
    var recompose by remember { mutableStateOf(0) }

    ConstraintLayout(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
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
            items(currentListShortInfo.size) {
                ShortInfoChip(
                    value = currentListShortInfo[it],
                    onDeleteItem = {
                        viewModel.deleteShortInfoItem(it)
                        recompose++
                        Log.e(
                            "ListShortInfoContainer",
                            "count items: ${viewModel.shortInfoMutableList.size}",
                        )
                    }
                )
            }
        }
    }


    LaunchedEffect(key1 = recompose, block = {
        currentListShortInfo = viewModel.shortInfoMutableList
        Log.e("ListShortInfoContainer", "recompose was success", )
    })

}

@Composable private fun ShortInfoChip(
    value: String,
    onDeleteItem: () -> Unit
) {
    var isAnim by remember { mutableStateOf(false) }
    var isAnimForDel by remember { mutableStateOf(0) }


    AnimatedVisibility(
        visible = isAnim,
        enter = slideInVertically(tween(400)) + fadeIn(tween(400)),
        exit = slideOutHorizontally(tween(400)) + fadeOut(tween(400))
    ) {

        _Add_Person_Container(
            modifier = Modifier.padding(horizontal = localSpacing.current.small)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .defaultMinSize(minWidth = 70.dp)
                    .background(MaterialTheme.colorScheme.tertiaryContainer)

            ) {
                SmallText(
                    value = value,
                    color = Primary95,
                    modifier = Modifier.padding(start = 10.dp),
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = { onDeleteItem() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = null,
                        tint = Primary95
                    )
                }
            }

        }


    }

    // For start anim
    LaunchedEffect(key1 = Unit, block = { isAnim = true })


}