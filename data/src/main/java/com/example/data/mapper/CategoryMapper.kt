package com.example.data.mapper

import com.example.data.remote.dto.CategoryDto
import com.example.data.remote.dto.CategoryItemDto
import com.example.domain.models.Category
import com.example.domain.models.CategoryItem

object CategoryMapper:Mapper<CategoryDto,Category> {
    override fun map(input: CategoryDto?): Category =


        if (input != null)
            Category(input.categories?.map {
                CategoryItemMapper.map(it)
            }?: emptyList())
        else
            Category()



    object CategoryItemMapper :Mapper<CategoryItemDto?, CategoryItem>{
        override fun map(input: CategoryItemDto?): CategoryItem =

            if (input!=null)
                CategoryItem(
                    input.idCategory?:"",
                    input.strCategory?:"",
                    input.strCategoryDescription?:"",
                    input.strCategoryThumb?:""
                )
            else
                CategoryItem(

                )

    }
}


