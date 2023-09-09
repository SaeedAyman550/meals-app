package com.example.domain.use_cases

import com.example.domain.models.Meals
import com.example.domain.repository.MealsRepo
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealsByCategoryUseCase @Inject constructor(private val repo:MealsRepo){


    operator fun invoke(categoryName:String)= flow<Resource<Meals>> {

        emit(Resource.Loading())
        try {
            emit(repo.getMealsByCategory(categoryName))
        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }


}