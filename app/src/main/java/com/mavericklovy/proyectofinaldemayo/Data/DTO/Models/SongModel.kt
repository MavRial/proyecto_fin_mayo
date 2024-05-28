package com.mavericklovy.proyectofinaldemayo.Data.DTO.Models

data class SongModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val url: String,
    val coverUrl: String,
){
    constructor() : this("","","","","")
}