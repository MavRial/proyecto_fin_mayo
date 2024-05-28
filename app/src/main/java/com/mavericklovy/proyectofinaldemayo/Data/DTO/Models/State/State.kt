package com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.State

sealed class State {
    data class Success(val info: categoryResponse?) : State()
    data class Error(val message: String) : State()
    object Loading : State()
}