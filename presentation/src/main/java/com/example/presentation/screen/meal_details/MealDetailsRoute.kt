package com.example.presentation.screen.meal_details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.presentation.screen.meal_details.MealDetailsArgs.Companion.idArgs


 const val MealDetailsRoute="mealDetailsRoute"
const val MealDetailsRouteWithArgs="${MealDetailsRoute}/{$idArgs}"

fun NavGraphBuilder.mealDetails(controller: NavController){

  composable(
      "${MealDetailsRouteWithArgs}",
      listOf(navArgument(idArgs){NavType.StringType})
  ){

      mealDetailsScreen()
  }


}


fun NavController.navigateToMealDetails(id:String)=navigate("${MealDetailsRoute}/${id}")



class MealDetailsArgs(savedStateHandle: SavedStateHandle){

    val id:String= checkNotNull(savedStateHandle[idArgs])

    companion object{
        const val idArgs="id"
    }

}