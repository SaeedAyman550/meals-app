package com.example.presentation.screen.meal_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.MealDetails
import com.example.domain.use_cases.GetMealDetailsUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val mealDetailsUseCase: GetMealDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
    ):ViewModel(){



    private val _mealDetailsState= MutableStateFlow<Resource<MealDetails>>(Resource.Loading())
    val mealDetailsState get() = _mealDetailsState


    private val args=MealDetailsArgs(savedStateHandle)

    init {
        getMealDetails()
    }


    private fun getMealDetails()=mealDetailsUseCase(args.id).onEach {
        when (it) {
            is Resource.Loading -> _mealDetailsState.emit(it)
            is Resource.Success -> _mealDetailsState.emit(it)
            is Resource.Error -> _mealDetailsState.emit(it)

        }

    }.launchIn(viewModelScope)




}