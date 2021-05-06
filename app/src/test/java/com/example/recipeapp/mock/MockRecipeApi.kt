package com.example.recipeapp.mock

import com.example.recipeapp.model.Recipe
import com.example.recipeapp.model.RecipePage
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
    ): Call<RecipePage> {
        val recipePage = RecipePage()
        val recipe = Recipe()
        val results = ArrayList<Recipe>()
        recipe.id = 1
        recipe.title = "Ginger Champagne"
        recipe.ingredients = "champagne, ginger, ice, vodka"
        recipe.thumbnail = "http://img.recipepuppy.com/1.jpg"

        results.add(recipe)
        recipePage.setResults(results)

        return object : Call<RecipePage> {
            @Throws(IOException::class)
            override fun execute(): Response<RecipePage> {
                return Response.success(recipePage)
            }

            override fun clone(): Call<RecipePage> {
                return this
            }

            override fun enqueue(callback: Callback<RecipePage>) {}

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


    override fun getRecipeById(id: Long?): Call<Recipe> {
        val recipe = Recipe()
        recipe.id = 1
        recipe.title = "Ginger Champagne"
        recipe.ingredients = "champagne, ginger, ice, vodka"
        recipe.thumbnail = "http://img.recipepuppy.com/1.jpg"

        return object : Call<Recipe> {
            @Throws(IOException::class)
            override fun execute(): Response<Recipe> {
                return Response.success(recipe)
            }

            override fun clone(): Call<Recipe> {
                return this
            }

            override fun enqueue(callback: Callback<Recipe>) {}

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

    override fun recipeCreate(data: Recipe) {
        TODO("Not yet implemented")
    }

    override fun recipeUpdate(id: Long, data: Recipe) {
        TODO("Not yet implemented")
    }

    override fun recipeDeleteById(id: Long) {
        TODO("Not yet implemented")
    }
}
