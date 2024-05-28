package com.mavericklovy.proyectofinaldemayo.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.category.categoryAdapter
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.favorite.favoriteAdapter
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.sectionSongs.sectionListAdapter
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.songListAdapter.songsListAdapter
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.SongModel
import com.mavericklovy.proyectofinaldemayo.Data.Services.MyExoPlayer
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentHomeBinding
import com.mavericklovy.proyectofinaldemayo.ui.Player.PlayerFragment
import com.mavericklovy.proyectofinaldemayo.ui.songs.SongsFragment

class HomeFragment : Fragment() {


    private val viewModel by lazy {ViewModelProvider(this).get(HomeViewModel::class.java)}

    private var categoryList:MutableList<CategoryModel> = mutableListOf()
    private lateinit var adapterCategory : categoryAdapter

    private var categoryllmanager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        getCategories()
        sectionInit()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun sectionInit(){
        initSections("section_1",binding.section1MainLayout,binding.tvSection1Title,binding.rvSection1)
        initSections("section_2",binding.section2MainLayout,binding.tvSection2Title,binding.rvSection2)
        initSections("section_3",binding.section3MainLayout,binding.tvSection3Title,binding.rvSection3)
        initMostlyPlayed("mostly_played",binding.moslyPlayedMainLayout,binding.moslyPlayedTitle,binding.rvMoslyPlayed)
    }

    fun getCategories(){
        FirebaseFirestore.getInstance().collection("category")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(CategoryModel::class.java)
                initCategoryRecyclerView(categoryList)
            }
    }

    fun initCategoryRecyclerView(categoryList : List<CategoryModel>){
        adapterCategory = categoryAdapter(
            categoryList

            )
        binding.rvCategories.adapter = adapterCategory
        binding.rvCategories.layoutManager = categoryllmanager

    }


    fun initSections(id:String, mainLayout : RelativeLayout,titleView:TextView,recyclerView:RecyclerView){
        FirebaseFirestore.getInstance().collection("sections")
            .document(id)
            .get().addOnSuccessListener {
                val section = it.toObject(CategoryModel::class.java)
                section?.apply {
                    mainLayout.visibility = View.VISIBLE
                    titleView.text = section.name
                    recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                    recyclerView.adapter = sectionListAdapter(songs)

                    mainLayout.setOnClickListener(object : View.OnClickListener{
                            override fun onClick(v: View?) {
                                val activity = v!!.context as AppCompatActivity
                                val songsFragment = SongsFragment()
                                SongsFragment.category = section
                                activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,songsFragment).addToBackStack(null).commit()

                            }
                    })
                }
            }
    }

    fun initMostlyPlayed(id:String, mainLayout : RelativeLayout,titleView:TextView,recyclerView:RecyclerView){
        FirebaseFirestore.getInstance().collection("sections")
            .document(id)
            .get().addOnSuccessListener {
                //get mostly played songs
                FirebaseFirestore.getInstance().collection("Songs")
                    .orderBy("count",Query.Direction.DESCENDING)
                    .limit(5)
                    .get().addOnSuccessListener {songListSnapshot ->
                     val songsModelList = songListSnapshot.toObjects<SongModel>()
                     val songsIdList = songsModelList.map {
                         it.id
                     }.toList()
                        var section = it.toObject(CategoryModel::class.java)
                        section?.apply {
                            mainLayout.visibility = View.VISIBLE
                            titleView.text = name
                            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                            recyclerView.adapter = sectionListAdapter(songsIdList)
                            section.songs = songsIdList
                            mainLayout.setOnClickListener(object : View.OnClickListener{
                                override fun onClick(v: View?) {
                                    val activity = v!!.context as AppCompatActivity
                                    val songsFragment = SongsFragment()
                                    SongsFragment.category = section
                                    activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,songsFragment).addToBackStack(null).commit()

                                }
                            })
                        }
                    }
            }
    }
}

