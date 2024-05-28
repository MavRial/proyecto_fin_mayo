package com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.favorite

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.FavoriteModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.SongModel
import com.mavericklovy.proyectofinaldemayo.Data.Services.MyExoPlayer
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.ItemFavoriteRowBinding
import com.mavericklovy.proyectofinaldemayo.ui.Player.PlayerFragment


class favoriteViewHolder( view: View): RecyclerView.ViewHolder(view) {


    val binding = ItemFavoriteRowBinding.bind(view)

    fun render(
        favoriteListModel: FavoriteModel,

        ){

//        FirebaseFirestore.getInstance().collection("Songs")
//            .document(songId).get()
//            .addOnSuccessListener {
//                val song = it.toObject(SongModel::class.java)
//                song?.apply {
//                    binding.tvSectionTitle.text = title
//                    binding.tvSectionSubtitle.text = subtitle
//                    Glide.with(binding.ivSectionCover).load(coverUrl)
//                        .apply(
//                            RequestOptions().transform(RoundedCorners(32))
//                        )
//                        .into(binding.ivSectionCover)

//                    itemView.setOnClickListener(object :View.OnClickListener{
//                        override fun onClick(v: View?) {
//                            val activity = v!!.context as AppCompatActivity
//                            val playerFragment = PlayerFragment()
//                            MyExoPlayer.startPlaying(binding.root.context,song)
//                            activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,playerFragment).addToBackStack(null).commit()
//
//                        }
//                    })
                }
            }