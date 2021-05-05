package com.example.recipeapp.ui.main

import com.example.recipeapp.model.Recipe

interface MainScreen {
    fun showRecipes(recipes: List<Recipe>?)
    fun showMessage(message: String)
}