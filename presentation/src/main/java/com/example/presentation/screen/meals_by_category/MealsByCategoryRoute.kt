package com.example.presentation.screen.meals_by_category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.presentation.screen.meal_details.navigateToMealDetails
import com.example.presentation.screen.meals_by_category.MealsByCategoryArgs.Companion.categoryNameArgs

const val MealsByCategoryRoute="mealsByCategoryRoute"
const val MealsByCategoryRouteWithArgs="${MealsByCategoryRoute}/{${categoryNameArgs}}"

fun NavGraphBuilder.mealsByCategory(controller: NavController){

    composable(
        "${MealsByCategoryRouteWithArgs}",
        listOf(navArgument(categoryNameArgs){ NavType.StringType})
    ){

        mealsByCategoryScreen(){
            controller.navigateToMealDetails(it.idMeal)
        }
    }


}

fun NavController.navigateToMealsByCategory(categoryName:String)=navigate("$MealsByCategoryRoute/${categoryName}")


class MealsByCategoryArgs(savedStateHandle: SavedStateHandle){

    val categoryName:String= checkNotNull(savedStateHandle[categoryNameArgs])


    companion object{
        const val categoryNameArgs="categoryName"
    }

}