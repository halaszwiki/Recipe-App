package com.example.recipeapp.interactor

import com.example.recipeapp.interactor.recipes.RecipesInteractor
import com.example.recipeapp.network.RecipeApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideRecipesInteractor(recipeApi: RecipeApi) = RecipesInteractor(recipeApi)
}