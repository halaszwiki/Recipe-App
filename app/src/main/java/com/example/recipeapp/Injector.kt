package com.example.recipeapp

import android.app.Activity
import androidx.fragment.app.Fragment

val Activity.injector: RecipeAppApplicationComponent
    get() {
        return (this.applicationContext as RecipeAppApplication).injector
    }

val Fragment.injector: RecipeAppApplicationComponent
    get() {
        return (this.context!!.applicationContext as RecipeAppApplication).injector
    }