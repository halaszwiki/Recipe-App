package com.example.recipeapp.data

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideDao(context: Context) : RecipeDao {
        return AppDatabase.getInstance(context).recipeDao()
    }
}