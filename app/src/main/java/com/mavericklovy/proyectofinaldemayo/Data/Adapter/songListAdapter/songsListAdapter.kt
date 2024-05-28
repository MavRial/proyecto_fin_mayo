package com.mavericklovy.proyectofinaldemayo.Data.Adapter.songListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mavericklovy.proyectofinaldemayo.R

class songsListAdapter(
    private val songIdList: List<String>,
//    private val onClickListener: (CategoryModel) -> Unit,

):
    RecyclerView.Adapter<songsListViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): songsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return songsListViewHolder(layoutInflater.inflate(R.layout.item_songs_rv_row,parent,false))
    }

    override fun onBindViewHolder(holder: songsListViewHolder, position: Int) {
        val item = songIdList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return songIdList.size
    }

}