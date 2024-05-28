package com.mavericklovy.proyectofinaldemayo.ui.Player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.bumptech.glide.Glide
import com.mavericklovy.proyectofinaldemayo.Data.Services.MyExoPlayer
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentPlayerBinding
import com.mavericklovy.proyectofinaldemayo.ui.Delete.DeleteViewModel

class PlayerFragment : Fragment() {

    lateinit var exoPlayer : ExoPlayer

    var playerListener = object : Player.Listener{
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            showGif(isPlaying)
        }
    }


    private var _binding: FragmentPlayerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val playerViewModel =
            ViewModelProvider(this).get(DeleteViewModel::class.java)

        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        MyExoPlayer.getCurrentSong()?.apply {
            binding.tvSongTitle.text = title
            binding.tvSongSubTitle.text = subtitle
            Glide.with(binding.ivSongImage).load(coverUrl)
                .circleCrop()
                .into(binding.ivSongImage)
            Glide.with(binding.ivSongGif).load(R.drawable.media_playing)
                .circleCrop()
                .into(binding.ivSongGif)
            exoPlayer = MyExoPlayer.getInstance()!!
            binding.playerView.player = exoPlayer
            exoPlayer.addListener(playerListener)
            binding.playerView.showController()

        }



        return root
    }


    fun showGif(show:Boolean){
        if (show) {
            binding.ivSongGif.visibility = View.VISIBLE
        } else {
            binding.ivSongGif.visibility = View.INVISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        exoPlayer?.removeListener(playerListener)
        _binding = null

    }
}