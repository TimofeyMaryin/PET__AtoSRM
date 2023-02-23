package com.example.atosrm.presentation.fr.add_person_srm.module

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.atosrm.presentation.ui.dimenston.localSpacing
import com.example.atosrm.presentation.ui.dimenston.localWidth

@Composable fun _Add_Person_Container(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(localWidth.current.large)
            .padding(vertical = localSpacing.current.small)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
