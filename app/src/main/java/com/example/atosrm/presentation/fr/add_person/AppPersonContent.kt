package com.example.atosrm.presentation.fr.add_person

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.atosrm.presentation.ui.dimenston.localWidth
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atosrm.R
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.elements.AppTextField
import com.example.atosrm.presentation.ui.elements.text.LargeText


@Composable fun AppPersonContent(viewModel: AddPersonViewModel) {

    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AvatarElement(viewModel = viewModel)

    }
}




@Composable private fun AvatarElement(viewModel: AddPersonViewModel){
    val width = localWidth.current
    Column(
        modifier = Modifier.fillMaxWidth(width.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
                .background(MaterialTheme.colorScheme.inversePrimary),
            contentAlignment = Alignment.Center
        ) {
            if(viewModel.isSelectAvatar){
                Image(painter = painterResource(id = R.drawable.img), contentDescription = null, modifier = Modifier.fillMaxSize())
            } else {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }
        
        LargeText(value = R.string.element_name_avatar)

        
        Container { AppTextField(placeHolder = R.string.test_text, desc = R.string.test_text, value = "", onChangeValue = {}) }
        Container { AppTextField(placeHolder = R.string.test_text, desc = R.string.test_text, value = "", onChangeValue = {}) }
        Container { AppTextField(placeHolder = R.string.test_text, desc = R.string.test_text, value = "", onChangeValue = {}) }
        Container { AppTextField(placeHolder = R.string.test_text, desc = R.string.test_text, value = "", onChangeValue = {}) }


    }
}


@Composable private fun Container(content: @Composable () -> Unit) = Box(modifier = Modifier.padding(vertical = localSpacing.current.medium).fillMaxWidth(), contentAlignment = Alignment.Center, content = { content() })


@Composable
@Preview
private fun PreviewContent() {
    val viewModel:AddPersonViewModel = viewModel()
    AppPersonContent(viewModel)

}