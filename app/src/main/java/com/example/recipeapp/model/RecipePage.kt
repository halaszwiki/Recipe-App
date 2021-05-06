package com.example.recipeapp.model

import com.google.gson.annotations.SerializedName


data class RecipePage(
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("version")
        val version: Number? = null,
        @SerializedName("href")
        val href: String? = null,
        @SerializedName("results")
        val results: List<Results>? = null
)




