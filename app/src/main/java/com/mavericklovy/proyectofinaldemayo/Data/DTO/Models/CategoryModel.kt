package com.mavericklovy.proyectofinaldemayo.Data.DTO.Models

data class CategoryModel(
    val name:String,
    val coverUrl :String,
    var songs: List<String>
){
    constructor(): this("","", listOf())
}

