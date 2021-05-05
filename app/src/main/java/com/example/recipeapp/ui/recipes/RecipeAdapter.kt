package com.example.recipeapp.ui.recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.model.Recipe
import kotlinx.android.synthetic.main.card_recipe.view.*

class RecipeAdapter constructor(
    private val context: Context,
    private var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_recipe, viewGroup, false)
        return ViewHolder(itemView)
        }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvName: TextView = view.tvName
    }

    private fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]

        Glide.with(context).load(recipe.thumbnail).into(holder.ivImage);

        holder.tvName.text = recipe.title
    }

    override fun getItemCount() = recipes.size

    companion object {
        const val KEY_RECIPE_ID = "KEY_RECIPE_ID"
    }
}