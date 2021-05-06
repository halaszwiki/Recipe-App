package com.example.recipeapp.data

import androidx.room.*
import com.example.recipeapp.model.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

}