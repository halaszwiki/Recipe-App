package com.example.recipeapp.interactor.recipes

import android.util.Log
import com.example.recipeapp.interactor.recipes.event.GetRecipesEvent
import com.example.recipeapp.network.RecipeApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class RecipesInteractor @Inject constructor(private var recipeApi: RecipeApi) {

    fun getRecipes(){
        val event = GetRecipesEvent()

        try{
            val recipeGetQuery = recipeApi.getRecipes(null, null, null, null)

            val response = recipeGetQuery.execute()
            Log.d("Response", response.body().toString())
            if(response.code() != 200)
                throw Exception("Page not found")

            event.code = response.code()
            event.recipes = response.body()?.results

        } catch (e: Exception){
            event.throwable = e;
        } finally {
            EventBus.getDefault().post(event);
        }
    }

}