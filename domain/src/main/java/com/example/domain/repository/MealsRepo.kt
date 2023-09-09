package com.example.domain.repository

import com.example.domain.models.Category
import com.example.domain.models.Meals
import com.example.domain.models.MealDetails
import com.example.domain.utils.Resource

interface MealsRepo {

    suspend fun getCategory(): Resource<Category>

   suspend fun getMealsByCategory(categoryName:String):Resource<Meals>

    suspend fun getMealDetails( id:String): Resource<MealDetails>
}