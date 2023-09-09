package com.example.domain.use_cases

import com.example.domain.models.Category
import com.example.domain.repository.MealsRepo
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCategoryUseCase @Inject constructor(private val repo: MealsRepo) {


    operator fun invoke()= flow<Resource<Category>> {

        emit(Resource.Loading())
        try {
            emit(repo.getCategory())
        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }

}