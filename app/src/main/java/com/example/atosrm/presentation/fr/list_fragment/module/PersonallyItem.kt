package com.example.atosrm.presentation.fr.list_fragment.module

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.airbnb.lottie.model.content.CircleShape
import com.example.atosrm.R
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.domain.utils.decodeBitmap
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth
import com.example.atosrm.presentation.ui.elements.text.DefaultText
import com.example.atosrm.presentation.ui.elements.text.LargeText
import com.example.atosrm.presentation.ui.elements.text.SmallText

@Composable fun PersonallyItem(
    person: PersonSRM,
    onClickAction: () -> Unit,
) {
    val spacing = localSpacing.current
    Log.e("PersonallyItem", "person avatar: ${person.avatar}", )
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
            .defaultMinSize(minHeight = 120.dp)
            .clickable { onClickAction() }
            .fillMaxWidth(localWidth.current.extraLarge),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(localWidth.current.large),
        ) {
            val (icon, personName, skills, shortInfo, exitButton, rightShadow, leftShadow) = createRefs()

            Image(
                bitmap = person.avatar.decodeBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(icon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top, margin = spacing.small)
                    }
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )

            LargeText(
                value = person.fullName,
                modifier = Modifier.constrainAs(personName) {
                    top.linkTo(icon.top)
                    start.linkTo(icon.end, margin = spacing.small)
                },
            )

            DefaultText(value = person.skills, modifier = Modifier.constrainAs(skills) {
                top.linkTo(personName.bottom)
                start.linkTo(icon.end, margin = spacing.small)
            })



            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .constrainAs(shortInfo) {
                        top.linkTo(skills.bottom)
                        start.linkTo(icon.end, margin = spacing.small)
                    }
            ) {
                items(person.shortInfo) {
                    if (it.isNotEmpty()) {
                        Box(modifier = Modifier.padding(end = 5.dp, top = 10.dp), contentAlignment = Alignment.Center){
                            ShortInfoItem(value = it)
                        }
                    }
                }
            }

            // Shadow for tags
            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(20.dp)
                    .background(Brush.horizontalGradient(
                        0.0f to MaterialTheme.colorScheme.primary,
                        1.0f to Color.Transparent
                    ))
                    .constrainAs(rightShadow) {
                        top.linkTo(skills.bottom)
                        start.linkTo(icon.end, margin = spacing.small)
                }
            )


            Icon(
                painter = painterResource(id = R.drawable.read_more),
                contentDescription = null,
                modifier = Modifier.constrainAs(exitButton) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}



