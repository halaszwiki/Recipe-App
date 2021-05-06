package com.example.recipeapp.ui.details

import com.example.recipeapp.interactor.recipes.RecipesInteractor
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter  @Inject constructor (private val executor: Executor,
                                             private val recipesInteractor: RecipesInteractor): Presenter<DetailsScreen>()  {

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen()
    }


    fun getRecipe(){
        executor.execute{

        }
    }

}