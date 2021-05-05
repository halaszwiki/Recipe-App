package com.example.recipeapp.interactor.recipes.event

import com.example.recipeapp.model.Recipe

data class GetRecipeEvent (
    var recipe: Recipe? = null,
    var code: Int? = 0,
    var throwable: Throwable? = null
)