package com.example.recipeapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.injector
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.ui.recipes.RecipeAdapter
import kotlinx.android.synthetic.main.fragment_recipes.*
import javax.inject.Inject
import android.view.LayoutInflater as LayoutInflater1

class MainFragment : Fragment(), MainScreen {
    private val displayedRecipes: MutableList<Recipe> = mutableListOf()
    private var recipeAdapter: RecipeAdapter? = null

    private lateinit var llm: LinearLayoutManager

    private val lastVisibleItemPosition: Int
        get() = llm.findLastVisibleItemPosition()

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        mainPresenter.attachScreen(this)
    }

    override fun onPause() {
        mainPresenter.detachScreen()
        super.onPause()
    }

    override fun onDetach() {
        mainPresenter.detachScreen()
        super.onDetach()
    }

    override fun showRecipes(recipes: List<Recipe>?) {
        displayedRecipes.clear()
        if(recipes != null) {
            displayedRecipes.addAll(recipes)
            recipeAdapter?.notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater1,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewRecipes.layoutManager = llm

        recipeAdapter = RecipeAdapter(context!!, displayedRecipes)
        recyclerViewRecipes.adapter = recipeAdapter

        val scrollListener = object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                if(totalItemCount == lastVisibleItemPosition + 1){
                    mainPresenter.refreshRecipes("")
                }
            }
        }

        recyclerViewRecipes.addOnScrollListener(scrollListener)
        mainPresenter.refreshRecipes("")
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val bundle = Bundle()

            fragment.arguments = bundle
            return fragment

        }
    }
}