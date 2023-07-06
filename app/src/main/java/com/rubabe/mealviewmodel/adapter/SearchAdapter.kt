package com.rubabe.mealviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rubabe.mealviewmodel.R
import com.rubabe.mealviewmodel.model.Meals
import com.squareup.picasso.Picasso

class SearchAdapter(private var list: List<Meals>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var strMeal = itemView.findViewById<TextView>(R.id.strMeal)
        var strCategory = itemView.findViewById<TextView>(R.id.strCategory)
        var strArea = itemView.findViewById<TextView>(R.id.strArea)
        var image = itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = list[position]
        holder.strMeal.text = meal.strMeal
        holder.strCategory.text = meal.strCategory
        holder.strArea.text = meal.strArea
        Picasso.get().load(meal.strMealThumb).into(holder.image);
    }
}