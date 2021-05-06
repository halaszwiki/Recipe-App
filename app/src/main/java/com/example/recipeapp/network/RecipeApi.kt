package com.example.recipeapp.network

import com.example.recipeapp.model.Recipe
import com.example.recipeapp.model.RecipePage
import retrofit2.Call
import retrofit2.http.*


interface RecipeApi {

    @GET("recipe")
    fun getRecipes(
        @Query("name") name: String?,
        @Query("ingredients") ingredients: String?,
        @Query("imageUrl") imageUrl: String?
    ): Call<RecipePage>

    @GET("recipe/{recipeId}")
    fun getRecipeById(
        @Path("recipeId") id: Long?
    ): Call<Recipe>

    @POST("recipe")
    fun recipeCreate(@Body data: Recipe)

    @PUT("recipe/{id}")
    fun recipeUpdate(@Path("id") id: Long, @Body data: Recipe)

    @DELETE("recipe/{id}")
    fun recipeDeleteById(@Path("id") id: Long)
}