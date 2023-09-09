package com.example.presentation.screen.meals_by_category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Meals
import com.example.domain.use_cases.GetMealsByCategoryUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MealsByCategoryViewModel @Inject constructor(
    private val mealsUseCase: GetMealsByCategoryUseCase,
    private val savedStateHandle: SavedStateHandle
    ):ViewModel() {


    private val _mealsByCategoryState= MutableStateFlow<Resource<Meals>>(Resource.Loading())
    val mealsByCategoryState get() = _mealsByCategoryState

    val categoryNameArgs= MealsByCategoryArgs(savedStateHandle)


    init {
        getMealsByCategory()
    }


    private fun getMealsByCategory()=mealsUseCase(categoryNameArgs.categoryName).onEach {
        when (it) {
            is Resource.Loading -> _mealsByCategoryState.emit(it)
            is Resource.Success -> _mealsByCategoryState.emit(it)
            is Resource.Error -> _mealsByCategoryState.emit(it)

        }

    }.launchIn(viewModelScope)




}