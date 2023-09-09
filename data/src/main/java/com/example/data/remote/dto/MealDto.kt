package com.example.data.remote.dto

data class MealDto(
    val meals: List<MealItemDto>?= emptyList()
    )



data class MealItemDto(
    val idMeal: String?="",
    val strMeal: String?="",
    val strMealThumb: String?=""
)