package com.example.presentation.screen.category

import android.util.Log
import android.widget.Scroller
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.Coil
import com.example.domain.models.CategoryItem
import com.example.domain.utils.Resource
import com.example.presentation.component.coilImage
import com.example.presentation.component.errorHolder
import com.example.presentation.component.loadingIndicator


@Composable
fun categoryScreen(viewModel: CategoryViewModel= hiltViewModel(),onClickCategory:(category:CategoryItem)->Unit){

    val state=viewModel.categoryState.collectAsState()

    when (state.value) {
        is Resource.Loading -> loadingIndicator()
        is Resource.Success -> state.value.data?.let {
            categoryContent(
            categoryList = it.categoriesList,
            onClickCategory = onClickCategory
        ) }
        is Resource.Error -> errorHolder(text = state.value.message.toString())
    }


}



@Composable
fun categoryContent(categoryList: List<CategoryItem> ,onClickCategory:(category:CategoryItem)->Unit){

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){


        items(categoryList){
            categoryItem(categoryItem = it,onClickCategory)
        }

    }


}




@Composable
fun categoryItem(categoryItem: CategoryItem,onClickCategory:(category:CategoryItem)->Unit){


    Row(
        modifier = Modifier.clickable { onClickCategory(categoryItem) }
    ) {
        coilImage(
            data = categoryItem.strCategoryThumb,
            contentDescription = categoryItem.strCategory,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 0.dp, 0.dp, 0.dp)) {

            Text(
                text = categoryItem.strCategory,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = categoryItem.strCategoryDescription,
                maxLines = 3
            )

        }


    }

}
