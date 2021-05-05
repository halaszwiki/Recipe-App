package com.example.recipeapp.ui.addRecipe

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.R
import com.example.recipeapp.ui.details.DetailsPresenter
import javax.inject.Inject

class AddRecipeActivity : AppCompatActivity() {

    @Inject
    lateinit var addRecipePresenter: AddRecipePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
        supportActionBar?.title = "Add recipe"
    }
}