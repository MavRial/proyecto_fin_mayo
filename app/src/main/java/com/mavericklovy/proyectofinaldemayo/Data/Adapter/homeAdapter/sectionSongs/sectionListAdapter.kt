package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.sectionSongs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.songListAdapter.songsListViewHolder
import com.mavericklovy.proyectofinaldemayo.R

class sectionListAdapter(
    private val songIdList: List<String>,
//    private val onClickListener: (CategoryModel) -> Unit,

):
RecyclerView.Adapter<sectionListViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sectionListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return sectionListViewHolder(layoutInflater.inflate(R.layout.item_section_song_recycler_view,parent,false))
    }

    override fun onBindViewHolder(holder: sectionListViewHolder, position: Int) {
        val item = songIdList[position]
        holder.render(item)
    }


    override fun getItemCount(): Int {
        return songIdList.size
    }

}