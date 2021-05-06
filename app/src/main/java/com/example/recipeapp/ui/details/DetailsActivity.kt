package com.example.recipeapp.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.injector
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.recipes.RecipeAdapter
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsScreen {

    private var displayedRecipe: Recipe = Recipe()


    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.title = "Recipe details"
        injector.inject(this)
        detailsPresenter.attachScreen(this)

    }

    override fun onDestroy() {
        detailsPresenter.detachScreen()
        super.onDestroy()
    }

    override fun onStart(){
        super.onStart()

    }

    override fun showDetails(recipe: Recipe) {
        tvTitle.text = recipe.title
        tvIngredients.text = recipe.ingredients
        Glide.with(this).load(recipe.thumbnail).into(ivImage)
        displayedRecipe = recipe
    }

}