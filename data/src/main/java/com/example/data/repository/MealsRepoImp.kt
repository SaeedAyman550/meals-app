package com.example.data.repository

import com.example.data.mapper.CategoryMapper
import com.example.data.mapper.MealDetailsMapper
import com.example.data.mapper.MealMapper
import com.example.data.remote.api.MealsApi
import com.example.domain.models.Category
import com.example.domain.models.Meals
import com.example.domain.models.MealDetails
import com.example.domain.repository.MealsRepo
import com.example.domain.utils.Resource

class MealsRepoImp(private val api: MealsApi) : MealsRepo{

    override suspend fun getCategory(): Resource<Category> {

        return try {
            val result=api.getCategory()
            if (result.isSuccessful&&result.body()!=null)
                Resource.Success(CategoryMapper.map(result.body()))
            else
                Resource.Error(result.message())
        }catch (e:Exception){
            Resource.Error(e.message.toString())
        }

    }

    override suspend fun getMealsByCategory(categoryName:String): Resource<Meals> {

        return try {
            val result=api.getMealsByCategory(categoryName)
            if (result.isSuccessful&&result.body()!=null)
                Resource.Success(MealMapper.map(result.body()))
            else
                Resource.Error(result.message())
        }catch (e:Exception){

            Resource.Error(e.message.toString())

        }
    }

    override suspend fun getMealDetails(id: String): Resource<MealDetails> {
        return try {
            val result=api.getMealDetails(id)
            if (result.isSuccessful&&result.body()!=null)
                Resource.Success(MealDetailsMapper.map(result.body()))
            else
                Resource.Error(result.message())
        }catch (e:Exception){

            Resource.Error(e.message.toString())

        }
    }


}