package com.example.domain.models

data class Meals(
    val meals:List<MealItem> = emptyList()
)



data class MealItem(
    val idMeal: String="",
    val strMeal: String="",
    val strMealThumb: String=""
)