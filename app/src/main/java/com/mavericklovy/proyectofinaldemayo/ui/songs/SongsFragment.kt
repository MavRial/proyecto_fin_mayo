package com.mavericklovy.proyectofinaldemayo.ui.songs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.songListAdapter.songsListAdapter
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentSongsBinding


class SongsFragment : Fragment() {

    companion object{
        lateinit var category : CategoryModel
    }
    lateinit var adapterSongsList : songsListAdapter
    private var _binding: FragmentSongsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val SongsViewModel =
            ViewModelProvider(this).get(SongsViewModel::class.java)

        _binding = FragmentSongsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tvFavoriteName.text = category.name
        Glide.with(binding.ivFavoriteCover).load(category.coverUrl)
            .apply(
                RequestOptions().transform (RoundedCorners(32))
            )
            .into(binding.ivFavoriteCover)

        initSongsListRecyclerView()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun initSongsListRecyclerView(){
        adapterSongsList = songsListAdapter(category.songs)
        binding.rvSongList.layoutManager = LinearLayoutManager(context)
        binding.rvSongList.adapter = adapterSongsList
    }
}