package com.example.presentation.screen.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Category
import com.example.domain.models.Meals
import com.example.domain.use_cases.GetCategoryUseCase
import com.example.domain.use_cases.GetMealsByCategoryUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryUseCase: GetCategoryUseCase
    ):ViewModel() {



    private val _categoryState= MutableStateFlow<Resource<Category>>(Resource.Loading())
    val categoryState get() = _categoryState

    init {
        getCategory()
    }



   private fun getCategory()=categoryUseCase().onEach {
        when (it) {
            is Resource.Loading -> _categoryState.emit(it)
            is Resource.Success -> _categoryState.emit(it)
            is Resource.Error -> _categoryState.emit(it)

        }

    }.launchIn(viewModelScope)








}