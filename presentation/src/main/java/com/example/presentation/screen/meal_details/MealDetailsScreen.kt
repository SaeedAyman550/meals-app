package com.example.presentation.screen.meal_details

import android.util.Log
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.models.MealDetails
import com.example.domain.utils.Resource
import com.example.presentation.R
import com.example.presentation.component.coilImage
import com.example.presentation.component.errorHolder
import com.example.presentation.component.loadingIndicator
import com.example.presentation.screen.category.categoryContent

@Composable
fun mealDetailsScreen(viewModel: MealDetailsViewModel = hiltViewModel()) {
    val state = viewModel.mealDetailsState.collectAsState()

    when (state.value) {
        is Resource.Loading -> loadingIndicator()
        is Resource.Success -> state.value.data?.let { mealDetailsContent(it) }
        is Resource.Error -> errorHolder(text = state.value.message.toString())
    }


}



@Composable
fun mealDetailsContent(mealDetails: MealDetails) {

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        coilImage(
            data = mealDetails.strMealThumb,
            contentDescription = mealDetails.strMeal,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(4.dp, 0.dp)) {
            textWithIcon(mealDetails.strMeal, R.drawable.meal, Modifier.weight(1f))
            textWithIcon(mealDetails.strArea, R.drawable.area, Modifier.weight(1f))

        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.mealDetailsInstractionsText),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp, 0.dp)
        )



        Text(
            text = mealDetails.strInstructions,
            modifier = Modifier
                .padding(8.dp)
        )

    }

}

@Composable
fun textWithIcon(title:String,iconDrawable:Int,modifier: Modifier){

    Row(modifier ) {
        Icon(painter = painterResource(id = iconDrawable), contentDescription = title)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = title)
    }

}
