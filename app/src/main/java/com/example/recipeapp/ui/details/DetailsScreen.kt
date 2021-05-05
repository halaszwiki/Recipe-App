package com.example.recipeapp.ui.details

import com.example.recipeapp.model.Recipe

interface DetailsScreen{
    fun showDetails(recipe: Recipe){}
}