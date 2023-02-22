package com.example.atosrm.presentation.fr.list_fragment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atosrm.data.person_srm.PersonSRM

@Composable fun ThereIsPerson(
    modifier: Modifier,
    value: MutableList<PersonSRM>
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
    }
}
@Composable
private fun Container(content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 2.dp), contentAlignment = Alignment.Center, content = { content() })
}
