package com.mavericklovy.proyectofinaldemayo.Data.Services

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.google.firebase.firestore.FirebaseFirestore

import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.SongModel

object MyExoPlayer {

    private var exoplayer :ExoPlayer? = null
    private var currentSong : SongModel? = null

    fun getCurrentSong():SongModel?{
        return currentSong
    }

    fun getInstance(): ExoPlayer?{
        return exoplayer
    }
    fun startPlaying(context: Context ,song:SongModel){
        if (exoplayer==null)
        exoplayer = ExoPlayer.Builder(context).build()

        if (currentSong!=song){
            // comienza al clickear nueva cancion
            currentSong = song
            updateCount()
            currentSong?.url?.apply {
                val mediaItem = MediaItem.fromUri(this)
                exoplayer?.setMediaItem(mediaItem)
                exoplayer?.prepare()
                exoplayer?.play()

            }
        }
    }

    private fun updateCount() {
        currentSong?.id?.let { id ->
            FirebaseFirestore.getInstance().collection("Songs")
                .document(id)
                .get().addOnSuccessListener {
                    var latestCount = it.getLong("count")
                    if (latestCount==null){
                        latestCount = 1L
                    }else{
                        latestCount = latestCount+1
                    }

                    FirebaseFirestore.getInstance().collection("Songs")
                        .document(id)
                        .update(mapOf("count" to latestCount))

                }
        }

    }
}