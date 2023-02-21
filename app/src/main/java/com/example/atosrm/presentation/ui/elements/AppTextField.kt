package com.example.atosrm.presentation.ui.elements

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.atosrm.R
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.elements.text.LargeText
import com.example.atosrm.presentation.ui.elements.text.SmallText
import com.example.atosrm.presentation.ui.theme.Primary30
import androidx.compose.ui.unit.sp


@Composable fun AppTextField(
    modifier: Modifier = Modifier,
    placeHolder: Int,
    desc: Int,
    value: String,
    onChangeValue: (String) -> Unit,
    maxValue: Int = Int.MAX_VALUE,
    maxLines: Int = Int.MAX_VALUE,
) {
    var isActive by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth().then(modifier)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                isActive = it.isNotEmpty()
                onChangeValue(it)
            },
            maxLines = maxLines,
            placeholder = {
                LargeText(value = placeHolder, color = MaterialTheme.colorScheme.background.copy(.4f))
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.background,
                unfocusedBorderColor = MaterialTheme.colorScheme.background.copy(.4f)
            ),
            textStyle = TextStyle.Default.copy(fontSize = 18.sp, color = MaterialTheme.colorScheme.background),
            modifier = Modifier.fillMaxWidth()
        )

        SmallText(
            value = desc,
            color = MaterialTheme.colorScheme.background.copy(if(isActive) 1.0f else 0.4f),
            modifier = Modifier.padding(start = localSpacing.current.large)
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable fun PreviewTextField() {
    Surface(
        color = Primary30,
        modifier = Modifier.padding(localSpacing.current.large)
    ) {
        var value by remember { mutableStateOf("") }
        AppTextField(
            placeHolder = R.string.test_text,
            desc = R.string.test_text,
            value = value,
            onChangeValue = { value = it }
        )
    }


}