package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter

import android.content.Intent
import android.view.RoundedCorner
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.databinding.ItemCategoryIrecyclerRowBinding
import com.mavericklovy.proyectofinaldemayo.ui.favorite.FavoriteSongsFragment

class categoryViewHolder(val view:View):ViewHolder(view) {

    val binding = ItemCategoryIrecyclerRowBinding.bind(view)

    fun render(
        categoryModel: CategoryModel,
//        onClickListener: (CategoryModel) -> Unit,
    ){
        Glide.with(binding.coverIv.context).load(categoryModel.coverUrl)
            .apply(RequestOptions().transform(RoundedCorners(32)))
            .into(binding.coverIv)
        binding.categoryTitle.text = categoryModel.name



    }

}