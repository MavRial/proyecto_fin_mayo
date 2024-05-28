package com.mavericklovy.proyectofinaldemayo.Data.Adapter.songListAdapter

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.SongModel
import com.mavericklovy.proyectofinaldemayo.Data.Services.MyExoPlayer
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.ItemSongsRvRowBinding
import com.mavericklovy.proyectofinaldemayo.ui.Player.PlayerFragment
import com.mavericklovy.proyectofinaldemayo.ui.songs.SongsFragment

class songsListViewHolder ( view: View): RecyclerView.ViewHolder(view) {


    val binding = ItemSongsRvRowBinding.bind(view)

    fun render(
        songId: String,
//        onClickListener: (CategoryModel) -> Unit,
    ){

        FirebaseFirestore.getInstance().collection("Songs")
            .document(songId).get()
            .addOnSuccessListener {
                val song = it.toObject(SongModel::class.java)
                song?.apply {
                    binding.tvSongTitle.text = title
                    binding.tvSongSubtitle.text = subtitle
                    Glide.with(binding.ivSongCover).load(coverUrl)
                        .apply(
                            RequestOptions().transform(RoundedCorners(32))
                        )
                        .into(binding.ivSongCover)

                    itemView.setOnClickListener(object :View.OnClickListener{
                        override fun onClick(v: View?) {
                            val activity = v!!.context as AppCompatActivity
                            val playerFragment = PlayerFragment()
                            MyExoPlayer.startPlaying(binding.root.context,song)
                            activity.supportFragmentManager.beginTransaction().replace(R.id.drawer_layout,playerFragment).addToBackStack(null).commit()

                        }
                    })
                }
            }
    }

}