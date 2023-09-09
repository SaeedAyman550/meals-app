package com.example.mealsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.get
import com.example.presentation.component.topAppBar
import com.example.presentation.navGraph.navGraph
import com.example.presentation.screen.category.AllCategoryRoute
import com.example.presentation.screen.meal_details.MealDetailsRoute
import com.example.presentation.screen.meal_details.MealDetailsRouteWithArgs
import com.example.presentation.screen.meals_by_category.MealsByCategoryRouteWithArgs
import com.example.presentation.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealsAppTheme {

                val controller = rememberNavController()
                Scaffold(
                    topBar = {
                       val route= controller.currentBackStackEntryAsState().value?.destination?.route
                        Log.d("saeed","${route}")
                        when(route){
                            AllCategoryRoute->topAppBar(getString(R.string.allCategoryAppBarText))
                            MealsByCategoryRouteWithArgs->topAppBar(getString(R.string.mealsByCategoryAppBarText))
                            MealDetailsRouteWithArgs->topAppBar(getString(R.string.mealDetailsAppBarText))
                            else->topAppBar(getString(R.string.mealsApp))
                        }
                    }
                ) {

                        navGraph(controller = controller)

                }
            }
        }
    }
}


