package com.example.recipeapp.interactor.recipes.event

import com.example.recipeapp.model.Results


data class GetRecipesEvent (
        var recipes: List<Results>? = null,
        var code: Int? = 0,
        var throwable: Throwable? = null
    )