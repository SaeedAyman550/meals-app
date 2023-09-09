package com.example.presentation.screen.meals_by_category

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.models.CategoryItem
import com.example.domain.models.MealItem
import com.example.domain.utils.Resource
import com.example.presentation.R
import com.example.presentation.component.coilImage
import com.example.presentation.component.errorHolder
import com.example.presentation.component.loadingIndicator


@Composable
fun mealsByCategoryScreen(viewModel: MealsByCategoryViewModel = hiltViewModel(),onClickMeal:(meal: MealItem)->Unit ){


    val state=viewModel.mealsByCategoryState.collectAsState()
    when (state.value) {
        is Resource.Loading -> loadingIndicator()
        is Resource.Success -> state.value.data?.let {
            if (it.meals.isEmpty())
                noMeals()
            else
                mealsByCategoryContent(it.meals, onClickMeal)
        }
        is Resource.Error -> errorHolder(text = state.value.message.toString())

    }

}



@Composable
fun noMeals(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = stringResource(R.string.mealsByCategoryNoMealsText),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

    }

}

@Composable
fun mealsByCategoryContent(mealsList: List<MealItem>,onClickMeal:(meal: MealItem)->Unit ){

    LazyColumn(
        contentPadding = PaddingValues(0.dp,8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){


        items(mealsList){
            mealItem( it,onClickMeal)
        }

    }


}


@Composable
fun mealItem(mealItem: MealItem,onClickMeal:(meal: MealItem)->Unit){


    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.clickable { onClickMeal(mealItem) }
    ) {
        Column() {

            coilImage(
                data = mealItem.strMealThumb,
                contentDescription = mealItem.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Text(
                    text = mealItem.strMeal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,

                )
            }



        }

    }



}