package com.example.recipeapp.ui.addRecipe

import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.Presenter
import com.example.recipeapp.ui.main.MainScreen
import org.greenrobot.eventbus.EventBus

class AddRecipePresenter : Presenter<AddRecipeScreen>() {

    override fun attachScreen(screen: AddRecipeScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }
}