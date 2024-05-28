package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.R

class categoryAdapter(
    private var categoryList: List<CategoryModel>,
//    private val onClickListener: (CategoryModel) -> Unit,

    ):
RecyclerView.Adapter<categoryViewHolder>(){



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


        }
    }