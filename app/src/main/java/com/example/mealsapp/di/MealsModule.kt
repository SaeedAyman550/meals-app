package com.example.mealsapp.di

import com.example.data.remote.api.MealsApi
import com.example.data.repository.MealsRepoImp
import com.example.domain.repository.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MealsModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MealsApi {
        return retrofit.create(MealsApi::class.java)
    }


        @Provides
        @Singleton
        fun provideMealzRepo(api: MealsApi): MealsRepo{
            return MealsRepoImp(api)

        }

}