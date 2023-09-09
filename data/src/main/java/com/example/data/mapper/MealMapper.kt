package com.example.data.mapper

import com.example.data.remote.dto.MealDto
import com.example.data.remote.dto.MealItemDto
import com.example.domain.models.Meals
import com.example.domain.models.MealItem

object MealMapper:Mapper<MealDto?,Meals> {
    override fun map(input: MealDto?): Meals =
        if (input != null)
            Meals(meals = input.meals?.map { MealItemMapper.map(it) }?: emptyList())
        else
            Meals()


    object MealItemMapper:Mapper<MealItemDto?, MealItem> {
        override fun map(input: MealItemDto?): MealItem =
            if (input != null)
                MealItem(
                    idMeal = input.idMeal ?: "",
                    strMeal = input.strMeal ?: "",
                    strMealThumb = input.strMealThumb ?: ""
                )
            else
                MealItem()
    }
}



