package com.example.recipeapp

import android.app.Application
import com.example.recipeapp.ui.UIModule


class RecipeAppApplication : Application() {
    lateinit var injector: RecipeAppApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRecipeAppApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}