package com.example.recipeapp

import com.example.recipeapp.interactor.InteractorModule
import com.example.recipeapp.mock.MockNetworkModule
import com.example.recipeapp.test.MainTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : RecipeAppApplicationComponent {
    fun inject(mainTest: MainTest)
}