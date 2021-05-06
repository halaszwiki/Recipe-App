package com.example.recipeapp.model

import com.google.gson.annotations.SerializedName


data class Results(
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("href")
        var href: String? = null,
        @SerializedName("ingredients")
        var ingredients: String? = null,
        @SerializedName("thumbnail")
        var thumbnail: String? = null
)


