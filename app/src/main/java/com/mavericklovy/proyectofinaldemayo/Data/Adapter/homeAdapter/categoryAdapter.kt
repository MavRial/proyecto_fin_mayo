package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.ui.favorite.FavoriteSongsFragment

class categoryAdapter(
    private var categoryList: List<CategoryModel>,
//    private val onClickListener: (CategoryModel) -> Unit,

    ):
RecyclerView.Adapter<categoryViewHolder>(){

//    private var categoryList: List<CategoryModel>,
//            fun setlist(data){
//                categoryList = data
//            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return categoryViewHolder(layoutInflater.inflate(R.layout.item_category_irecycler_row,parent,false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: categoryViewHolder, position: Int) {
        val item = categoryList[position]
        holder.render(item)
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val favoriteFragment = FavoriteSongsFragment()
                activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,favoriteFragment).addToBackStack(null).commit()
            }
        })

        }
    }