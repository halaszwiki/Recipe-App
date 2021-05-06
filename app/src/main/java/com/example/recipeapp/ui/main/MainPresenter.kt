package com.example.recipeapp.ui.main

import com.example.recipeapp.interactor.recipes.RecipesInteractor
import com.example.recipeapp.interactor.recipes.event.GetRecipesEvent
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val recipesInteractor: RecipesInteractor): Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen()
    }

    fun refreshRecipes(){
        executor.execute{
            recipesInteractor.getRecipes()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetRecipesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showMessage(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.recipes != null) {
                    screen?.showRecipes(event.recipes as MutableList<Recipe>)
                }

            }
        }
    }
}
