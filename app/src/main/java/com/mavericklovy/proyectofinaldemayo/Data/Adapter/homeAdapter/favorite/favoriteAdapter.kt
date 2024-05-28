package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.category.categoryViewHolder
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.FavoriteModel
import com.mavericklovy.proyectofinaldemayo.R

class favoriteAdapter(
    private var favoriteList: List<FavoriteModel>,
) :
    RecyclerView.Adapter<favoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return favoriteViewHolder(layoutInflater.inflate(R.layout.item_favorite_row, parent, false))

    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: favoriteViewHolder, position: Int) {
        val item = favoriteList[position]
        holder.render(item)

    }
}