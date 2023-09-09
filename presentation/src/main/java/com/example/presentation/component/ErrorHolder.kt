package com.example.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.presentation.R


@Composable
fun errorHolder(text:String, modifier:Modifier= Modifier.fillMaxSize()) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription =text ,
            modifier = Modifier.size(width = 250.dp, height = 250.dp)
        )

        Spacer(modifier = Modifier.width(width = 8.dp))


            Text(
                text = text,
                modifier = Modifier.padding(8.dp)
            )

    }
}
