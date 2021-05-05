package com.example.recipeapp.interactor.recipes.event

import com.example.recipeapp.model.Recipe

data class GetRecipesEvent (
    var recipes: List<Recipe?>? = null,
    var code: Int? = 0,
    var throwable: Throwable? = null
    )