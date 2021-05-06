package com.example.recipeapp.test

import com.example.recipeapp.model.Recipe
import com.example.recipeapp.testInjector
import com.example.recipeapp.ui.main.MainPresenter
import com.example.recipeapp.ui.main.MainScreen
import com.example.recipeapp.utils.argumentCaptor
import com.example.recipeapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "src/main/AndroidManifest.xml")
class MainTest {

    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Before
    @Throws(Exception::class)
    fun setup(){
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun test(){
        mainPresenter.refreshRecipes("")
        val list = argumentCaptor<List<Recipe>>()
        verify(mainScreen).showRecipes(list.capture())
        assert(list.value.isNotEmpty())
    }

    @After
    fun tearDown(){
        mainPresenter.detachScreen()
    }
}