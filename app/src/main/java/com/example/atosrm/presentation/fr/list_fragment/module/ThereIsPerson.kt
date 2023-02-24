package com.example.atosrm.presentation.fr.list_fragment.module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.atosrm.data.person_srm.PersonSRM

@Composable fun ThereIsPerson(
    modifier: Modifier,
    value: List<PersonSRM>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(value) {
            Container {
                PersonallyItem(person = it)
            }
        }
        
        item {
            Box(modifier = Modifier.fillMaxWidth().height(200.dp))
        }
    }
}
@Composable
private fun Container(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        contentAlignment = Alignment.Center,
        content = { content() }
    )
}
