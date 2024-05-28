package com.mavericklovy.proyectofinaldemayo.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.mavericklovy.proyectofinaldemayo.Data.Adapter.homeAdapter.categoryAdapter
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.databinding.FragmentHomeBinding
import com.mavericklovy.proyectofinaldemayo.ui.favorite.FavoriteSongsFragment

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





//        homeViewModel.fetchCategoryData().observe(cont, Observer { state ->
//            when (state) {
//                is State.Loading -> {
//                    // Mostrar loading
////                    binding.progressBar.visibility = View.VISIBLE
//                    binding.rvCategories.visibility = View.INVISIBLE
//                }
//                is State.Success -> {
////                    binding.progressBar.visibility = View.GONE
//                    // Mostrar datos de éxito
//                    categoryList = mutableListOf()
//                    state?.info?.message?.forEach {
//                        categoryList.add(CategoryModel(coverUrl = it, name = it))
//                    }
//                    initRecyclerView()
//                    binding.rvCategories.visibility = View.VISIBLE
//                }
//                is State.Error -> {
//                    // Mostrar mensaje de error
////                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(context,state.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        })



//        homeViewModel.listState.observe(viewLifecycleOwner){
//            madapter?.setItem(list = it)
//            binding.progress.isInvisible = true

//        }
//
//        homeViewModel.listState.observe(viewLifecycleOwner){show ->
//            binding.progress.isInvisible = true
//
//        }

//        viewModel.fechProductoData()












        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observe(){
        viewModel.fetchCategoryData()
        adapterCategory.setlist(categoryList)
        adapterCategory.notifyDataSetChanged()
    }

//    fun setCategoryData(data:MutableList<CategoryModel>){
//        categoryList = data
//    }

    fun getCategories(){
        FirebaseFirestore.getInstance().collection("category")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(CategoryModel::class.java)
                setupCategoryRecyclerView(categoryList)
            }
    }

    fun setupCategoryRecyclerView(categoryList : List<CategoryModel>){
        adapterCategory = categoryAdapter(
            categoryList,
//            onClickListener = { category -> categoryOnItemSelected(category)}
            )
        binding.rvCategories.adapter = adapterCategory
        binding.rvCategories.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

    }


//    private fun categoryOnItemSelected(category: CategoryModel) {
//        val intent = Intent(context, FavoriteSongsFragment::class.java)
//        intent.putExtra("data", category.coverUrl )
//
//
//
//
//
//        startActivity(intent)
//
//
//        }

    }


//    override fun itemSelect(producto: producto) {
//        viewModel.setItemSelection()
//        activity?.supportFragmentManager
//            ?.beginTransaction()
//            ?.replace(android.R.id.content, GalleryFragment.newInstance() )
//            ?.addToBackStack(null)
//            ?.commit()
//    }
