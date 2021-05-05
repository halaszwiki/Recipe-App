package com.example.recipeapp.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel

@ApiModel(description = "")
@Entity(tableName = "recipe")
public class Recipe {

        @PrimaryKey
        @SerializedName("id")
        var id: Long? = null
        @SerializedName("title")
        var title: String? = null
        @SerializedName("ingredients")
        var ingredients: String? = null
        @SerializedName("thumbnail")
        var thumbnail: String? = null


}



