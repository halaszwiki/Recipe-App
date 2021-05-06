package com.example.recipeapp.mock

import com.example.recipeapp.model.Recipe
import com.example.recipeapp.model.Results
import com.example.recipeapp.network.RecipeApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MockRecipeApi : RecipeApi {
    override fun getRecipes(
        name: String?,
        ingredients: String?,
        imageUrl: String?
    ): Call<Results> {
        val resultPage = Results()
        val recipe = Recipe()
        val results = ArrayList<Recipe>()
        recipe.title = "Ginger Champagne"
        recipe.ingredients = "champagne, ginger, ice, vodka"
        recipe.thumbnail = "http://img.recipepuppy.com/1.jpg"

        results.add(recipe)

        return object : Call<Results> {
            @Throws(IOException::class)
            override fun execute(): Response<Results> {
                return Response.success(resultPage)
            }

            override fun clone(): Call<Results> {
                return this
            }

            override fun enqueue(callback: Callback<Results>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                return Timeout()
            }
        }
    }

}
