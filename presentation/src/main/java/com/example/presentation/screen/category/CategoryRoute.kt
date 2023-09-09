package com.example.presentation.screen.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.presentation.screen.meals_by_category.navigateToMealsByCategory


const val AllCategoryRoute="allCategoryRoute"

fun NavGraphBuilder.allCategory(controller: NavController){

    composable(
        "${AllCategoryRoute}"
    ){

        categoryScreen(){
            controller.navigateToMealsByCategory(it.strCategory)
        }
    }


}




