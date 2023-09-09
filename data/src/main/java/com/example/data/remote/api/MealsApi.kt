package com.example.data.remote.api

import com.example.data.remote.dto.CategoryDto
import com.example.data.remote.dto.MealDetailsDto
import com.example.data.remote.dto.MealDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {

    @GET("categories.php")
   suspend fun getCategory(): Response<CategoryDto>


    @GET("filter.php?")
   suspend fun getMealsByCategory(@Query("i") categoryName:String):Response<MealDto>



    @GET("lookup.php?")
   suspend fun getMealDetails(@Query("i") id:String): Response<MealDetailsDto>

}