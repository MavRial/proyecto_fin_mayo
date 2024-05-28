package com.mavericklovy.proyectofinaldemayo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.CategoryModel
import com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.State.State
import com.mavericklovy.proyectofinaldemayo.Data.Repository.MusicGenApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel()  {

    private val repository = MusicGenApi()
//    fun fetchCategoryData(): LiveData<MutableList<CategoryModel>>{
//        val mutableData = MutableLiveData<MutableList<CategoryModel>>()
//        repository.getCategoryData().observeForever{category ->
//            mutableData.value = category
//        }
//        return mutableData
//    }
//
//    private val _data = MutableLiveData<State>()
//    val data: LiveData<State> get() = _data

//    fun callCategoryApi(){
//        _data.postValue(State.Loading)
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                val service = MusicGenApi.service
//                val response = service.get(3)
//                val call = response.execute().body()
//                //Log.i("HOLA",call.toString())
//                _data.postValue(StateDogs.Success(call))
//            } catch (e: Exception) {
//                //Log.i("HOLA",e.message.toString())
//                _data.postValue(StateDogs.Error("Error service"))
//            }
//        }
//    }

}