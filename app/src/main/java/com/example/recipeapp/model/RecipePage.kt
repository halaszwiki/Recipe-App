package com.example.recipeapp.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty


@ApiModel(description = "")
public class RecipePage {

    @SerializedName("results")
    private var results: List<Recipe> = ArrayList()

    @ApiModelProperty(value = "")
    fun getResults(): List<Recipe?> {
        return results
    }

    fun setResults(results: List<Recipe>) {
        this.results = results
    }

}