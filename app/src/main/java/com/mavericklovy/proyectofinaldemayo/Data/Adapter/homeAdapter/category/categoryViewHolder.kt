package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.category

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.ItemCategoryIrecyclerRowBinding
import com.mavericklovy.proyectofinaldemayo.ui.songs.SongsFragment

class categoryViewHolder( view:View):ViewHolder(view) {


    val binding = ItemCategoryIrecyclerRowBinding.bind(view)

    fun render(
        categoryModel: CategoryModel,
//        onClickListener: (CategoryModel) -> Unit,
    ){




        binding.categoryTitle.text = categoryModel.name
        Glide.with(binding.coverIv.context).load(categoryModel.coverUrl)
            .apply(RequestOptions().transform(RoundedCorners(32)))
            .into(binding.coverIv)




        itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val songsFragment = SongsFragment()
                SongsFragment.category = categoryModel
                activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,songsFragment).addToBackStack(null).commit()

            }
        })






    }

}