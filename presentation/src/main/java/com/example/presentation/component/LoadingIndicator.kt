package com.example.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun loadingIndicator(modifier: Modifier=Modifier.fillMaxSize()) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(size = 50.dp),
        )
        Spacer(modifier = Modifier.width(width = 8.dp))
        Text(text = "Loading...")
    }
}