package com.example.recipeapp.ui

import android.content.Context
import com.example.recipeapp.interactor.recipes.RecipesInteractor
import com.example.recipeapp.ui.addRecipe.AddRecipePresenter
import com.example.recipeapp.ui.details.DetailsPresenter
import com.example.recipeapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, recipesInteractor : RecipesInteractor) = MainPresenter(executor, recipesInteractor)

    @Provides
    @Singleton
    fun addRecipePresenter() = AddRecipePresenter()

    @Provides
    @Singleton
    fun detailsPresenter(executor: Executor, recipesInteractor : RecipesInteractor) = DetailsPresenter(executor, recipesInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}