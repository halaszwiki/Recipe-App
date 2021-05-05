package com.example.recipeapp.data

import androidx.room.*
import com.example.recipeapp.model.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getRecipeById(id: Long): Recipe

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

    @Insert
    fun insertRecipe(vararg recipe: Recipe)

    @Update
    fun updateRecipe(vararg recipe: Recipe)

    @Query("DELETE FROM recipe WHERE id = :id")
    fun deleteRecipe(id: Long)
}