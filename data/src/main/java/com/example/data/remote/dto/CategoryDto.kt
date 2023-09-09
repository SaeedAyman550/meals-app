package com.example.data.remote.dto

data class CategoryDto(
    val categories: List<CategoryItemDto>?= emptyList()
)

data class CategoryItemDto(
    val idCategory: String?="",
    val strCategory: String?="",
    val strCategoryDescription: String?="",
    val strCategoryThumb: String?=""
)