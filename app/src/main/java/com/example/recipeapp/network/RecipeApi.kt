package com.example.recipeapp.network

import com.example.recipeapp.model.RecipePage
import com.example.recipeapp.model.Results
import retrofit2.Call
import retrofit2.http.*

interface RecipeApi {

    @GET("/")
    fun getRecipes(
        @Query("title") name: String?,
        @Query("href") href: String?,
        @Query("ingredients") ingredients: String?,
        @Query("thumbnail") imageUrl: String?
    ): Call<RecipePage>
}