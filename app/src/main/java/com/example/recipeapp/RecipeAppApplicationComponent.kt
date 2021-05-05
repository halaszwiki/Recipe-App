package com.example.recipeapp

import com.example.recipeapp.interactor.InteractorModule
import com.example.recipeapp.network.NetworkModule
import com.example.recipeapp.ui.UIModule
import com.example.recipeapp.ui.addRecipe.AddRecipeActivity
import com.example.recipeapp.ui.details.DetailsActivity
import com.example.recipeapp.ui.main.MainActivity
import com.example.recipeapp.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface RecipeAppApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(detailsActivity: DetailsActivity)
    fun inject(mainFragment: MainFragment)
}