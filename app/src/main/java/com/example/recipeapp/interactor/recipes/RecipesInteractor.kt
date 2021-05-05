package com.example.recipeapp.interactor.recipes

import android.util.Log
import com.example.recipeapp.interactor.recipes.event.GetRecipeEvent
import com.example.recipeapp.interactor.recipes.event.GetRecipesEvent
import com.example.recipeapp.network.RecipeApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class RecipesInteractor @Inject constructor(private var recipeApi: RecipeApi) {

    fun getRecipes(name: String){
        val event = GetRecipesEvent()

        try{
            val recipeGetQuery = recipeApi.getRecipes(name, null, null)

            val response = recipeGetQuery!!.execute()
            Log.d("Response", response.body().toString())
            if(response.code() != 200)
                throw Exception("Page not found")

            event.code = response.code()
            event.recipes = response.body()?.getResults()
        } catch (e: Exception){
            event.throwable = e;
        } finally {
            EventBus.getDefault().post(event);
        }
    }

    fun getRecipe(id: Long){
        val event = GetRecipeEvent()

        try {
            val recipeGetQuery = recipeApi.getRecipeById(id)

            val response = recipeGetQuery?.execute()
            Log.d("Response", response?.body().toString())
            if(response?.code() != 200)
                throw Exception("Character not found")

            event.code = response.code()
            event.recipe = response.body()

        } catch (e: Exception){
            event.throwable = e;
        } finally {
            EventBus.getDefault().post(event);
        }
    }
}