package com.mavericklovy.proyectofinaldemayo.Data.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel


class MusicGenApi  {


//    fun getCategoryData():LiveData<MutableList<CategoryModel>>{
//        val mutableData = MutableLiveData<MutableList<CategoryModel>>()
//        FirebaseFirestore.getInstance().collection("category")
//            .get().addOnSuccessListener {result ->
//            val ListData = mutableListOf<CategoryModel>()
//            for (document in result){
//                val name = document.getString("name")
//                val coverUrl = document.getString("coverUrl")
//                val category = CategoryModel(name!!,coverUrl!!)
//                ListData.add(category)
//            }
//            mutableData.value = ListData
//        }
//        return  mutableData
    }
