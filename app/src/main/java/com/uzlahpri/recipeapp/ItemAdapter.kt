package com.uzlahpri.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_recipe.view.*

class ItemAdapter(private val listRecipe: ArrayList<Recipe>) :
    RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (recipe: Recipe){
            with(itemView){
                Glide.with(itemView.context).load(recipe.photo).apply(RequestOptions().override(150, 190))
                tv_name_food.text = recipe.name
                tv_description_food.text = recipe.description

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listRecipe.size


    override fun onBindViewHolder(holder: ItemAdapter.ListViewHolder, position: Int) {
        holder.bind(listRecipe[position])
    }
}