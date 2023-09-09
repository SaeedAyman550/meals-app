package com.example.data.mapper

import android.util.Log
import com.example.data.remote.dto.MealDetailsDto
import com.example.domain.models.MealDetails

object MealDetailsMapper:Mapper<MealDetailsDto?,MealDetails> {
    override fun map(input: MealDetailsDto?): MealDetails =
        if (input?.meals != null &&input.meals.isNotEmpty())
            MealDetails(
                idMeal = input.meals[0].idMeal ?: "",
                strArea = input.meals[0].strArea ?: "",
                strMealThumb = input.meals[0].strMealThumb ?: "",
                strInstructions = input.meals[0].strInstructions ?: "",
                strMeal = input.meals[0].strMeal ?: ""
            )
        else
            MealDetails()
}