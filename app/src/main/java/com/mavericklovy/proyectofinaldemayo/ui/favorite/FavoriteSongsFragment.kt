package com.mavericklovy.proyectofinaldemayo.ui.favorite

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mavericklovy.proyectofinaldemayo.R
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentFavoriteSongsBinding


class FavoriteSongsFragment : Fragment() {

    private var _binding: FragmentFavoriteSongsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val FavoriteSongsViewModel =
            ViewModelProvider(this).get(FavoriteSongsViewModel::class.java)

        _binding = FragmentFavoriteSongsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}