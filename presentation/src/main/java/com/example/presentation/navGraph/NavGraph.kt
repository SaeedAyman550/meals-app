package com.example.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.presentation.screen.category.AllCategoryRoute
import com.example.presentation.screen.category.allCategory
import com.example.presentation.screen.meal_details.mealDetails
import com.example.presentation.screen.meals_by_category.mealsByCategory

@Composable
fun navGraph(controller: NavHostController){

    NavHost(navController =controller , startDestination = AllCategoryRoute ){

        allCategory(controller = controller)
        mealsByCategory(controller=controller)
        mealDetails(controller = controller)
    }

}