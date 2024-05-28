package com.mavericklovy.proyectofinaldemayo.ui.gallery

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
import com.google.firebase.firestore.toObjects
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.sectionSongs.sectionListAdapter
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.SongModel
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentAddBinding

import com.mavericklovy.proyectofinaldemayo.ui.songs.SongsFragment

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addViewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun initFavorite(id:String, mainLayout : RelativeLayout, titleView: TextView, recyclerView: RecyclerView){
        FirebaseFirestore.getInstance().collection("sections")
            .document(id)
            .get().addOnSuccessListener {
                //get mostly played songs
                FirebaseFirestore.getInstance().collection("Songs")
                    .orderBy("count", Query.Direction.DESCENDING)
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
                            recyclerView.layoutManager = LinearLayoutManager(context,
                                LinearLayoutManager.HORIZONTAL,false)
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}