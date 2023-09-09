package com.example.domain.models

data class Category(
    val categoriesList: List<CategoryItem> = emptyList()
)

data class CategoryItem(
    val idCategory: String="",
    val strCategory: String="",
    val strCategoryDescription: String="",
    val strCategoryThumb: String=""
)